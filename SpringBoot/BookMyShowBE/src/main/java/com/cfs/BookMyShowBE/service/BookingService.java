package com.cfs.BookMyShowBE.service;

import com.cfs.BookMyShowBE.GlobalException.BookingException;
import com.cfs.BookMyShowBE.GlobalException.CustomerNotFound;
import com.cfs.BookMyShowBE.GlobalException.SeatNotAvailable;
import com.cfs.BookMyShowBE.GlobalException.ShowNotFound;
import com.cfs.BookMyShowBE.dto.CreateBookingRequest;
import com.cfs.BookMyShowBE.dto.ResponseDto.BookingResponse;
import com.cfs.BookMyShowBE.entity.*;
import com.cfs.BookMyShowBE.repository.BookingRepository;
import com.cfs.BookMyShowBE.repository.CustomerRepository;
import com.cfs.BookMyShowBE.repository.ShowRepository;
import com.cfs.BookMyShowBE.repository.ShowSeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
@Service
public class BookingService {
    private final ShowRepository showRepository;
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private  final ShowSeatRepository showSeatRepository;
    public BookingService(ShowRepository showRepository, BookingRepository bookingRepository, CustomerRepository customerRepository,ShowSeatRepository showSeatRepository) {
        this.showRepository = showRepository;
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
     this.showSeatRepository=showSeatRepository;
    }

    @Transactional
    public BookingResponse book(Long showId, CreateBookingRequest request)
    {
        Show show=showRepository.findById(showId).orElseThrow(()->new ShowNotFound("Show not found"));
        var customer=customerRepository.findById(request.profileId())
                .orElseThrow(()->new CustomerNotFound("Profile not found"));

        //lables --> j1 j3  k1 k3
//        List<String> labels = request.seatLabels().stream()
//                .map(lable -> lable.trim().toUpperCase(Locale.ROOT)).toList();
        List<String> labels = request.seatLabels()
                .stream()
                .map(label ->
                        label.trim().toUpperCase(Locale.ROOT)
                )
                .toList();
        if(labels.stream().distinct().count()!= labels.size())
        {
            throw new SeatNotAvailable("Duplicate seat labels are not allowed");
        }
        List<ShowSeat> seats=showSeatRepository.findForUpdate(showId,labels);
        if(seats.size()!= labels.size() || seats.stream().anyMatch(ShowSeat::isReserved))
        {
            throw new SeatNotAvailable("One or more selected seats are unavailable");
        }
        seats.forEach(ShowSeat::reserve);
        show.reserve(labels.size());

        BigDecimal total=show.getTicketPrice().multiply(BigDecimal.valueOf(labels.size()));
        Booking booking = bookingRepository.save(new Booking(show, customer, total, labels));
        return BookingResponse.from(booking);
    }

//    @Transactional
//    public BookingResponse find(Long bookingId)
//    {
//        Booking booking = bookingRepository.findById(bookingId)
//                .orElseThrow(() -> new BookingException ("Booking not found"));
//
//        return BookingResponse.from(booking);
//    }

    @Transactional
    public BookingResponse find(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingException("Booking not found"));

        return BookingResponse.from(booking);
    }

    @Transactional
    public List<BookingResponse> findByProfileId(Long customerId) {

        if (!customerRepository.existsById(customerId)) {

            throw new CustomerNotFound(
                    "Customer not found with this " + customerId
            );
        }

        List<BookingResponse> list =
                bookingRepository
                        .findByCustomerIdOrderByBookedAtDesc(customerId)
                        .stream()
                        .map(BookingResponse::from)
                        .toList();

        return list;
    }
//
//@Transactional
//    public BookingResponse cancel(Long bookingId,Long customerID){
////        first we need to find booking id is booking matches then we cancel it by removing it
////    then we need to release our seats , reserved to unreserved
//
//    Booking booked=bookingRepository.findByIdAndCustomerId(bookingId,customerID).orElseThrow(()->
//            new BookingException("Booking not found with this id" + bookingId));
//if(booked.getStatus()== BookingStatus.CONFIRMED){
//    List<ShowSeat> seats=showSeatRepository.findForUpdate(booked.getShow().getId(),booked.getSeatLabels());
//    seats.forEach(ShowSeat::release);
//booked.cancel();
//
//}
//return BookingResponse.from(booked);
@Transactional
public BookingResponse cancel(Long bookingId, Long profileId) {

    // 1. Find the booking belonging to this customer
    Booking booked = bookingRepository
            .findByIdAndCustomerId(bookingId, profileId)
            .orElseThrow(() ->
                    new BookingException(
                            "Booking not found with this id " + bookingId
                    ));

    // 2. Only confirmed bookings can be cancelled
    if (booked.getStatus() == BookingStatus.CONFIRMED) {

        // 3. Lock the seats and fetch them
        List<ShowSeat> seats = showSeatRepository.findForUpdate(
                booked.getShow().getId(),
                booked.getSeatLabels()
        );

        // 4. Release individual seats
        seats.forEach(ShowSeat::release);

        // 5. Increase show's available seat count
        booked.getShow().release(booked.getSeatLabels().size());

        // 6. Mark booking as cancelled
        booked.cancel();
    }

    // 7. Return updated booking
    return BookingResponse.from(booked);
}
    }

