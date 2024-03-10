package com.example.AntraHW.controllers;

import com.example.AntraHW.entities.AuthRequest;
import com.example.AntraHW.services.AuthenticateService;
import com.example.AntraHW.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
public class AuthenticateController {

    private AuthenticateService authenticateService;
    private JwtService jwtService;

    @Autowired
    public AuthenticateController(AuthenticateService authenticateService, JwtService jwtService) {
        this.authenticateService = authenticateService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest){
        System.out.println("Login:   " + authRequest.getUsername() + " " + authRequest.getPassword());
        Boolean isAuthenticated = authenticateService.authenticate(authRequest.getUsername(), authRequest.getPassword());
        if(!isAuthenticated) return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
        final UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final String token = jwtService.generateToken(userDetails);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

}