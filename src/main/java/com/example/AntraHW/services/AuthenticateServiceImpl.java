package com.example.AntraHW.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateServiceImpl implements AuthenticateService{

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticateServiceImpl(AuthenticationManager manager) {
        this.authenticationManager = manager;
    }

    @Override
    public Boolean authenticate(String username, String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (AuthenticationException e) {
            System.out.println("Incorrect Username or password: " + " name: " + username);
            return false;
        }
        return true;
    }
}
