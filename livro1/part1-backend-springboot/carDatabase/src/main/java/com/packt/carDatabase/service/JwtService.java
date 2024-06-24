package com.packt.carDatabase.service;

import java.security.Key;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

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

    // get a token from request authorization header
    // verify token and get userName
    public String getAuthUser(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        String user = null; // Initialize the variable with a default value
        if (token != null) {
            user = Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token.replace(PREFIX, ""))
            .getBody()
            .getSubject();
            if (user == null) {
                return null;
            }
            return user;
        }
        return user;
    }

}
