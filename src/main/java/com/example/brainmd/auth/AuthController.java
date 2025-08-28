package com.example.brainmd.auth;

import com.example.brainmd.auth.dto.GoogleDto;
import com.example.brainmd.auth.dto.GoogleUserDto;
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
            GoogleUserDto response = authService.getGoogleData(googleDto.getToken());
            String token = authService.generateToken(response.getEmail(), response.getName());

            Map<String, Object> res = new HashMap<>();
            res.put("response", "generated");
            res.put("token", token);
            res.put("name", response.getName());
            res.put("email", response.getEmail());
            res.put("picture", response.getPicture());

            return ResponseEntity.ok(res);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token.");
        }
    }
}
