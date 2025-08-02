package com.opdheal.auth_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private String role;
    private String provider; // "local" or "google"
    private String providerId; // For OAuth2 user ID
    private String name;
    private String imageUrl;
    
    // Constructor for local registration
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.provider = "local";
        this.role = "ROLE_USER";
    }
    
    // Constructor for OAuth2 registration
    public User(String name, String email, String imageUrl, String provider, String providerId) {
        this.name = name;
        this.email = email;
        this.username = email; // Use email as username for OAuth2 users
        this.imageUrl = imageUrl;
        this.provider = provider;
        this.providerId = providerId;
        this.password = ""; // OAuth2 users don't have a password
        this.role = "ROLE_USER";
    }
}