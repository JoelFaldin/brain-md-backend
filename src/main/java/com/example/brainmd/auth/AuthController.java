package com.example.brainmd.auth;

import com.example.brainmd.auth.dto.GoogleDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService service) {
        this.authService = service;
    }

    @PostMapping("/google")
    public ResponseEntity<?> googleAuth(@RequestBody GoogleDto googleDto) {
        try {
            String token = authService.generateToken(googleDto.getEmail(), googleDto.getName());

            Map<String, Object> response = new HashMap<>();
            response.put("response", "generated");
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token.");
        }
    }
}
