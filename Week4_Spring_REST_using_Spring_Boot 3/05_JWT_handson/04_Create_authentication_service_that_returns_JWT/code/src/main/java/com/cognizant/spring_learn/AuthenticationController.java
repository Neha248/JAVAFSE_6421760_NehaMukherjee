package com.cognizant.spring_learn;

import com.cognizant.spring_learn.util.JwtUtil;
import com.cognizant.spring_learn.model.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public AuthResponse authenticate(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new RuntimeException("Missing or invalid Authorization header.");
        }

        // Decode the credentials
        String base64Credentials = authHeader.substring("Basic ".length()).trim();
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decodedBytes);

        // Split username and password
        final String[] values = credentials.split(":", 2);
        String username = values[0];
        String password = values[1];

        // NOTE: For demo, we're hardcoding username and password
        if (!username.equals("user") || !password.equals("pwd")) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(username);
        return new AuthResponse(token);
    }
}
