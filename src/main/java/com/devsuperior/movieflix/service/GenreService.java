package com.devsuperior.movieflix.service;

import com.devsuperior.movieflix.dto.GenreDto;
import com.devsuperior.movieflix.entity.Genre;
import com.devsuperior.movieflix.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    @Transactional(readOnly = true)
    public List<GenreDto> findAll(){
        List<Genre> list = genreRepository.findAll();
        return list.stream().map(GenreDto::new).collect(Collectors.toList());
    }
}
