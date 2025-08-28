package com.example.brainmd.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class AuthService {

    @Value("${jwt.secret}")
    private String secret;

    private static Key key;

    @PostConstruct
    public void init() {
        key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public static String generateToken(String email, String name) {
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + 3600_000;
        Date now = new Date(nowMillis);
        Date expiration = new Date(expMillis);

        return Jwts.builder()
                .setSubject(name)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(key)
                .compact();
    }
}
