
package com.cfs.BookMyShowBE.repository;

import com.cfs.BookMyShowBE.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {

    boolean existsByMovieIdAndTheatreIdAndStartsAt(Long movieId, Long theatreId, LocalDateTime startsAt);
    @Query("""
    SELECT s
    FROM Show s
    JOIN FETCH s.movie m
    JOIN FETCH s.theatre t
    WHERE s.active = true
      AND m.active = true
      AND t.city = :city
      AND s.startsAt >= :from
      AND s.startsAt < :to
    ORDER BY s.startsAt
""")
    List<Show> findActiveShows(
            @Param("city") String city,
            @Param("from") LocalDateTime from,
            @Param("to") LocalDateTime to
    );
}