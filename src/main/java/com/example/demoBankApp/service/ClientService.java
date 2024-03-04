package com.example.demoBankApp.service;

import com.example.demoBankApp.dto.request.ClientRequest;
import com.example.demoBankApp.dto.request.LoginRequest;
import com.example.demoBankApp.dto.response.ClientResponse;
import com.example.demoBankApp.dto.response.LoginResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClientService {
    Optional<ClientResponse> registerClient(ClientRequest request);
    Page<ClientResponse> findAllByPage(Pageable pageable);
    Optional<LoginResponse> loginUser(LoginRequest request);
}
