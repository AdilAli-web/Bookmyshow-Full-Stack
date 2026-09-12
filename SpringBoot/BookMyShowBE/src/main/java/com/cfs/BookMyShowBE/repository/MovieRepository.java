package com.cfs.BookMyShowBE.repository;

import com.cfs.BookMyShowBE.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findByActiveTrueOrderByTitle();

    Optional<Movie> findByTitle(String title);
}
