package com.cfs.BookMyShowBE.controller;

import com.cfs.BookMyShowBE.dto.CreateBookingRequest;
import com.cfs.BookMyShowBE.dto.ResponseDto.BookingResponse;
import com.cfs.BookMyShowBE.entity.Booking;
import com.cfs.BookMyShowBE.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/shows/{showId}")
    public ResponseEntity<BookingResponse> book(
            @PathVariable Long showId,
          @Valid @RequestBody CreateBookingRequest createBookingRequest) {

        BookingResponse booking =
                bookingService.book(showId, createBookingRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(booking);
    }
//@PostMapping("/{bookingId}/cancel")
//    public ResponseEntity<BookingResponse> cancel(@PathVariable Long bookingId,@RequestBody Long profileId){
//BookingResponse cancelBooking=bookingService.cancel(bookingId,profileId);
//return ResponseEntity.status(HttpStatus.OK).body(cancelBooking);
//}
@PostMapping("/{bookingId}/cancel")
public ResponseEntity<BookingResponse> cancel(
        @PathVariable Long bookingId,
        @RequestParam Long  profileId) {

    BookingResponse cancelledBooking =
            bookingService.cancel(bookingId, profileId);

    return ResponseEntity.ok(cancelledBooking);
}

//all booking response user who booked the tickets
//
@GetMapping("/{bookingId}")
public ResponseEntity<BookingResponse> find(@PathVariable Long bookingId) {
    BookingResponse bookingResponse = bookingService.find(bookingId);
    return ResponseEntity.ok(bookingResponse);
}

}
