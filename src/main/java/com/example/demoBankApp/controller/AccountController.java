package com.example.demoBankApp.controller;

import com.example.demoBankApp.dto.AccountFilterDto;
import com.example.demoBankApp.dto.request.AccountRequest;
import com.example.demoBankApp.dto.request.BranchRequest;
import com.example.demoBankApp.dto.response.AccountResponse;
import com.example.demoBankApp.dto.response.BranchResponse;
import com.example.demoBankApp.service.AccountService;
import com.example.demoBankApp.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/account")
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/save")
    public Optional<AccountResponse> registerAccount(@RequestBody AccountRequest request){
        return accountService.saveAccount(request);
    }

    @PostMapping("/filter")
    public List<AccountResponse> filterAccount(@RequestBody AccountFilterDto filterDto){
        return accountService.filterAccounts(filterDto);
    }

}
