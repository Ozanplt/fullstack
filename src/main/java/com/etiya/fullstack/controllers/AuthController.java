package com.etiya.fullstack.controllers;

import com.etiya.fullstack.entities.requests.auth.LoginRequest;
import com.etiya.fullstack.entities.requests.auth.RegisterRequest;
import com.etiya.fullstack.entities.responses.auth.AuthenticationResponse;
import com.etiya.fullstack.services.abstracts.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {
    private final AuthService authService;

    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        var authResponse = authService.register(request);
        return new ResponseEntity<AuthenticationResponse>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request){
        var authResponse = authService.login(request);
        return new ResponseEntity<AuthenticationResponse>(authResponse, HttpStatus.OK);
    }
}