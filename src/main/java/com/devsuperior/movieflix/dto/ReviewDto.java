package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ReviewDto implements Serializable {

    private Long id;
    @NotBlank(message = "text should not be empty")
    private String text;
    private Long movieId;
    private UserDto user;

    public ReviewDto(Review entity) {
        id = entity.getId();
        text = entity.getText();
        movieId = entity.getMovie().getId();
        user = new UserDto(entity.getUser());
    }


}
