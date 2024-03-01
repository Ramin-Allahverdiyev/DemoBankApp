package com.example.demoBankApp.controller;

import com.example.demoBankApp.dto.request.BranchRequest;
import com.example.demoBankApp.dto.request.ClientRequest;
import com.example.demoBankApp.dto.response.BranchResponse;
import com.example.demoBankApp.dto.response.ClientResponse;
import com.example.demoBankApp.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/branch")
public class BranchController {
    private final BranchService branchService;

    @PostMapping("/save")
    public Optional<BranchResponse> registerUser(@RequestBody BranchRequest request){
        return branchService.saveBranch(request);
    }
}
