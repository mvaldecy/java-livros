package com.packt.carDatabase.service;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
    static final long EXPIRATIONTIME = 86400000;
    static final String PREFIX = "Bearer";
    static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    
    // Generate jwt token
    public String getToken(String userName) {
        String token = Jwts.builder()
        .setSubject(userName)
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
        .signWith(key)
        .compact();
        return token;
    }

}
