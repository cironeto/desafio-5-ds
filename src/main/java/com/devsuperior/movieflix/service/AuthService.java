package com.devsuperior.movieflix.service;

import com.devsuperior.movieflix.entity.User;
import com.devsuperior.movieflix.repository.UserRepository;
import com.devsuperior.movieflix.service.exception.ForbiddenException;
import com.devsuperior.movieflix.service.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User getAuthenticatedUser() {
        try {
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.findByEmail(userName);
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid user");
        }
    }



}
