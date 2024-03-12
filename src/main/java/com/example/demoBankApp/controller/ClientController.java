package com.example.demoBankApp.controller;

import com.example.demoBankApp.dto.request.ClientRequest;
import com.example.demoBankApp.dto.response.ClientResponse;
import com.example.demoBankApp.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/client")
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/register")
    public Optional<ClientResponse> registerClient(@RequestBody @Valid ClientRequest request){
        return clientService.registerClient(request);
    }

    @GetMapping("/all")
    public Page<ClientResponse> findAllByPage(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "2") int sizePerPage,
                                              @RequestParam(defaultValue = "ID") String sortField,
                                              @RequestParam(defaultValue = "DESC") Sort.Direction sortDirection) {
        Pageable pageable = PageRequest.of(page, sizePerPage, sortDirection, sortField.toLowerCase());
        return clientService.findAllByPage(pageable);
    }

}
