package com.opdheal.auth_service.service;

import com.opdheal.auth_service.model.User;
import com.opdheal.auth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String register(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return "Username already exists!";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");  // default role

        userRepository.save(user);
        return "User registered successfully!";
    }

    public String login(String username, String rawPassword) {
        return userRepository.findByUsername(username)
                .filter(user -> passwordEncoder.matches(rawPassword, user.getPassword()))
                .map(user -> "Login successful!")
                .orElse("Invalid credentials!");
    }
}
