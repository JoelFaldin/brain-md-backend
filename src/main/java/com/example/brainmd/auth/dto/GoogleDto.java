package com.example.brainmd.auth.dto;

import jakarta.validation.constraints.NotBlank;

public class GoogleDto {
    @NotBlank(message = "You should provide a token!")
    private String token;

    public GoogleDto(String token) {
        this.token = token;
    }

    // Getters and setters:
    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
