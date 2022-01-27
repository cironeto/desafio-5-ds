package com.devsuperior.movieflix.service;

import com.devsuperior.movieflix.dto.ReviewDto;
import com.devsuperior.movieflix.entity.Review;
import com.devsuperior.movieflix.entity.User;
import com.devsuperior.movieflix.repository.MovieRepository;
import com.devsuperior.movieflix.repository.ReviewRepository;
import com.devsuperior.movieflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final AuthService authService;

    @Transactional
    @PreAuthorize("hasAnyRole('MEMBER')")
    public ReviewDto insert(ReviewDto dto) {
        User currentUser = authService.getAuthenticatedUser();

        Review entity = new Review();
        entity.setText(dto.getText());
        entity.setMovie(movieRepository.getOne(dto.getMovieId()));
        entity.setUser(currentUser);

        reviewRepository.save(entity);

        return new ReviewDto(entity);
    }

}
