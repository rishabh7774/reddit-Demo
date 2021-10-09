package com.example.redditDemo.controller;

import com.example.redditDemo.dto.AuthenticationResponse;
import com.example.redditDemo.dto.LoginRequest;
import com.example.redditDemo.dto.RegisterRequest;
import com.example.redditDemo.exceptions.PhoneNumberValidationException;
import com.example.redditDemo.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody RegisterRequest registerRequest, Error error) throws PhoneNumberValidationException {
        System.out.println(error.getMessage());
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Success", HttpStatus.OK);
    }

    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated", HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
