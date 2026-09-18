package com.cfs.BookMyShowBE.service;

import com.cfs.BookMyShowBE.dto.ResponseDto.MovieResponse;
import com.cfs.BookMyShowBE.dto.ResponseDto.ShowResponse;
import com.cfs.BookMyShowBE.dto.ResponseDto.TheatreResponse;
import com.cfs.BookMyShowBE.entity.Movie;
import com.cfs.BookMyShowBE.entity.Show;
import com.cfs.BookMyShowBE.entity.Theatre;
import com.cfs.BookMyShowBE.repository.MovieRepository;
import com.cfs.BookMyShowBE.repository.ShowRepository;
import com.cfs.BookMyShowBE.repository.ShowSeatRepository;
import com.cfs.BookMyShowBE.repository.TheatreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
//@AllArgsConstructor
public class CatalogService {
    public CatalogService(MovieRepository movieRepository, TheatreRepository theatreRepository, ShowRepository showRepository,ShowSeatRepository showSeatRepository) {
        this.movieRepository = movieRepository;
        this.theatreRepository = theatreRepository;
        this.showRepository = showRepository;
        this.showSeatRepository=showSeatRepository;
    }

    private final MovieRepository movieRepository;
    private final TheatreRepository theatreRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
//    public List<MovieResponse> movies() {
//        List<Movie> movies = movieRepository.findByActiveTrueOrderByTitle();
//        List<MovieResponse> responses = new ArrayList<>();
//
//        for (Movie movie : movies) {
//            responses.add(MovieResponse.from(movie));
//        }
//
//        return responses;
//
//    }

    public List<MovieResponse> movies()
    {
        return movieRepository.findByActiveTrueOrderByTitle().stream().map(MovieResponse::from).toList();
    }
    public List<TheatreResponse> theatres(String city){

        List<Theatre> theatres=theatreRepository.findByCityIgnoreCaseOrderByName(city);

        List<TheatreResponse> responses=new ArrayList<>();
        for (Theatre theatre: theatres){
            responses.add(TheatreResponse.from(theatre));
        }
        return responses;
    }
//public List<ShowResponse> shows(String city, LocalDate date){
//    LocalDateTime from=date.atStartOfDay();
////    List<ShowResponse> responses=new ArrayList<>();
////    List<Show> shows=showRepository.findActiveShows(city,from,from.plusDays(1));
////        for(Show show:shows){
////            responses.add()
////        }
//  return showRepository.findActiveShows(city,from,from.plusDays(1))
//          .stream().map(show-> ShowResponse.from(show, showSeatRepository.findAvailableLabels(show.getId()))).toList();
//}
public List<ShowResponse> shows(String city, LocalDate date)
{
    LocalDateTime from=date.atStartOfDay();
    return showRepository.findActiveShows(city,from,from.plusDays(1)).stream()
            .map(show -> ShowResponse.from(show,showSeatRepository.findAvailableLabels(show.getId()))).toList();
}


}
