package com.devsuperior.movieflix.controller;

import com.devsuperior.movieflix.entity.User;
import com.devsuperior.movieflix.service.AuthService;
import com.devsuperior.movieflix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private AuthService authService;

    @GetMapping(value = "/profile")
    public ResponseEntity<User> returnCurrentAuthenticatedUser() {
        return ResponseEntity.ok(authService.getAuthenticatedUser());
    }
}
