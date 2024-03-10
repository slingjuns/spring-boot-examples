package com.example.AntraHW.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateToken(UserDetails userDetails);
    Boolean validateToken(String token, UserDetails userDetails);
    String getUsernameFromToken(String token);
}