package com.example.brainmd.auth.dto;

import jakarta.validation.constraints.NotBlank;

public class GoogleDto {
    @NotBlank(message = "You should provide an email!")
    private String email;

    @NotBlank(message = "You should provide a name!")
    private String name;

    protected GoogleDto() {}

    public GoogleDto(String email, String name) {
        this.email = email;
        this.name = name;
    }

    // Getters and setters:
    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
