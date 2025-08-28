package com.example.brainmd.auth;

import com.example.brainmd.auth.dto.GoogleUserDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Value("${google.url}")
    private String googleUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public GoogleUserDto getGoogleData(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<GoogleUserDto> response = restTemplate.exchange(
                googleUrl,
                HttpMethod.GET,
                entity,
                GoogleUserDto.class
        );

        return response.getBody();
    }
}
