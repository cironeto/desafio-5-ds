package com.devsuperior.movieflix.repository;

import com.devsuperior.movieflix.entity.Genre;
import com.devsuperior.movieflix.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT obj FROM Movie obj " +
            "WHERE (obj.genre = :genreName OR :genreName IS NULL) " +
            "ORDER BY obj.title")
    Page<Movie> findByGenre(Genre genreName, Pageable pageable);

}
