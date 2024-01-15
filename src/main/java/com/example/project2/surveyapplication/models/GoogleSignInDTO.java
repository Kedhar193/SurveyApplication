package com.example.project2.surveyapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GoogleSignInDTO {

    @Id
    private String googleId;
    private String name;
    private String imageUrl;
    private String email;

    // Constructors, getters, and setters

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
