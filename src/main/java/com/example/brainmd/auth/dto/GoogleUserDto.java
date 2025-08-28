package com.example.brainmd.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GoogleUserDto {
    private String sub;
    private String name;
    private String given_name;
    private String family_name;
    private String picture;
    private String email;

    @JsonProperty("email_verified")
    private boolean emailVerified;

    private String locale;

    // Getters and setters
    public String getSub() { return sub; }
    public void setSub(String sub) { this.sub = sub; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGiven_name() { return given_name; }
    public void setGiven_name(String given_name) { this.given_name = given_name; }

    public String getFamily_name() { return family_name; }
    public void setFamily_name(String family_name) { this.family_name = family_name; }

    public String getPicture() { return picture; }
    public void setPicture(String picture) { this.picture = picture; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isEmailVerified() { return emailVerified; }
    public void setEmailVerified(boolean emailVerified) { this.emailVerified = emailVerified; }

    public String getLocale() { return locale; }
    public void setLocale(String locale) { this.locale = locale; }
}
