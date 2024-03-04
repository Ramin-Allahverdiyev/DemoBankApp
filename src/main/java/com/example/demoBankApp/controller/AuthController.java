package com.example.demoBankApp.controller;

import com.example.demoBankApp.dto.request.LoginRequest;
import com.example.demoBankApp.dto.response.LoginResponse;
import com.example.demoBankApp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/auth")
public class AuthController {
    private final ClientService clientService;
    @PostMapping("/login")
    public Optional<LoginResponse> loginUser(@RequestBody LoginRequest request){
        return clientService.loginUser(request);
    }
}
