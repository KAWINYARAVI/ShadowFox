package com.example.authservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody UserCredentials credentials) {
        // Simulated authentication logic
        if ("user1".equals(credentials.getUsername()) && "password1".equals(credentials.getPassword())) {
            // Generate JWT token (for simplicity, returning a dummy token)
            return "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImlhdCI6MTYyNTQwNjg2MywiZXhwIjoxNjI1NDEwNDYzfQ.hMoMfVJ-u1ndzS46a9EEjM2B8O6LOiIn5l_jJGt1Y9A";
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    // Other endpoints: token refresh, logout, etc.
}
