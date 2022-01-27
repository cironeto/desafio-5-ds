package com.devsuperior.movieflix.controller;

import com.devsuperior.movieflix.dto.GenreDto;
import com.devsuperior.movieflix.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public ResponseEntity<List<GenreDto>> findAll(){
        return ResponseEntity.ok(genreService.findAll());
    }
}
