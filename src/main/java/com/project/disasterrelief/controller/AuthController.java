package com.project.disasterrelief.controller;

import com.project.disasterrelief.dto.LoginRequest;
import com.project.disasterrelief.model.User;
import com.project.disasterrelief.security.JwtUtil;
import com.project.disasterrelief.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // You can add validation checks here (e.g., duplicate email/username)
        if (userService.findByUsernameOrEmail(user.getUsername()) != null ||
                userService.findByUsernameOrEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Username or email already exists");
        }

        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest request) {
        User user = userService.findByUsernameOrEmail(request.getUsernameOrEmail());
        System.out.println("LOGIN REQUEST: " + request.getUsernameOrEmail());
        System.out.println("PASSWORD: " + request.getPassword());
        if (user == null) {
            return ResponseEntity.status(401).body("Invalid username/email");
        }
        System.out.println("USER FOUND: " + (user != null ? user.getUsername() : "null"));
        // Verify password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            System.out.println("PASSWORDS DO NOT MATCH");
            return ResponseEntity.status(401).body("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getUsername(), String.valueOf(user.getRole()));

        // Return JWT token as the response
        return ResponseEntity.ok("Bearer " + token);
    }




}
