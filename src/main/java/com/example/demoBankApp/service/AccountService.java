package com.example.demoBankApp.service;

import com.example.demoBankApp.dto.AccountFilterDto;
import com.example.demoBankApp.dto.request.AccountRequest;
import com.example.demoBankApp.dto.response.AccountResponse;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Optional<AccountResponse> saveAccount(AccountRequest request);
    List<AccountResponse> filterAccounts(AccountFilterDto accountFilterDto);
}
