package com.bank.auth_service.controller;

import com.bank.auth_service.dto.AuthResponse;
import com.bank.auth_service.dto.LoginRequest;
import com.bank.auth_service.dto.RegisterRequest;
import com.bank.auth_service.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        authService.register(request);
        return ResponseEntity.ok(
                new AuthResponse("User registered successfully", null)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody LoginRequest request) {

        String token = authService.login(request);
        return ResponseEntity.ok(
                new AuthResponse("Login successful", token)
        );
    }

}
