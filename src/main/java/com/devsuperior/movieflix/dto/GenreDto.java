package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GenreDto implements Serializable {

    private Long id;
    private String name;


    public GenreDto(Genre entity){
        id = entity.getId();
        name = entity.getName();
    }
}
