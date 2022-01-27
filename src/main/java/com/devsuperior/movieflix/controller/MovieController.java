package com.devsuperior.movieflix.controller;

import com.devsuperior.movieflix.dto.MovieDto;
import com.devsuperior.movieflix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<MovieDto>> findByGenre(
            @RequestParam(value = "genreId", defaultValue = "0") Long genreId,
            Pageable pageable){
        return ResponseEntity.ok(movieService.findByGenre(genreId, pageable));
    }
}
