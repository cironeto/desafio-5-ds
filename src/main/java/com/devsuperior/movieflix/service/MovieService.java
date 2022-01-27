package com.devsuperior.movieflix.service;

import com.devsuperior.movieflix.dto.MovieDto;
import com.devsuperior.movieflix.entity.Genre;
import com.devsuperior.movieflix.entity.Movie;
import com.devsuperior.movieflix.repository.GenreRepository;
import com.devsuperior.movieflix.repository.MovieRepository;
import com.devsuperior.movieflix.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    @Transactional(readOnly = true)
    public MovieDto findById(Long id) {
        Optional<Movie> movieOpt = movieRepository.findById(id);
        Movie entity = movieOpt
                .orElseThrow(() -> new ResourceNotFoundException("ID not found"));
        return new MovieDto(entity);
    }

    @Transactional(readOnly = true)
    public Page<MovieDto> findByGenre(Long genreId, Pageable pageable) {
        Genre genre = (genreId == 0) ? null : genreRepository.getOne(genreId);
        Page<Movie> page = movieRepository.findByGenre(genre, pageable);
        return page.map(MovieDto::new);
    }
}
