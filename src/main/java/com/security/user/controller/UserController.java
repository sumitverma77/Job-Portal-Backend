package com.security.user.controller;

import com.security.user.dto.request.LoginRequest;
import com.security.user.entity.User;
import com.security.user.dto.request.RegisterRequest;
import com.security.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public User register(@RequestBody RegisterRequest registerRequest) {
        return userService.registerUser(registerRequest);
    }
    @PostMapping("login")
    public UserDetails login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest); // Call the login method
    }

    @GetMapping("csrf/")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }


}
