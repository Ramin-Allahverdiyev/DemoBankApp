package com.example.demoBankApp.service.impl;

import com.example.demoBankApp.dto.AccountFilterDto;
import com.example.demoBankApp.dto.request.AccountRequest;
import com.example.demoBankApp.dto.response.AccountResponse;
import com.example.demoBankApp.entity.Account;
import com.example.demoBankApp.entity.Branch;
import com.example.demoBankApp.entity.Client;
import com.example.demoBankApp.mapper.AccountMapper;
import com.example.demoBankApp.repository.AccountRepository;
import com.example.demoBankApp.service.AccountService;
import jakarta.persistence.criteria.Join;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private static final Logger logger= LoggerFactory.getLogger(BranchServiceImpl.class);
    @Override
    public Optional<AccountResponse> saveAccount(AccountRequest request) {
        logger.info("ActionLog.saveAccount.start request: {}",request);
        var account = AccountMapper.INSTANCE.dtoToEntity(request);
        var savedAccount = accountRepository.save(account);
        var response=AccountMapper.INSTANCE.entityToDto(savedAccount);
        logger.info("ActionLog.saveAccount.stop response: {}",response);
        return Optional.of(response);
    }
    @Override
    public List<AccountResponse> filterAccounts(AccountFilterDto accountFilterDto) {
        Specification<Account> accountSpecification = getAccountSpecification(accountFilterDto);
        return accountRepository.findAll(accountSpecification).stream().map(AccountMapper.INSTANCE::entityToDto).toList();
    }


    private Specification<Account> getAccountSpecification(AccountFilterDto accountFilterDto){
        accountFilterDto.setAccountName("%" + accountFilterDto.getAccountName() + "%");

        Specification<Account> accountNameSpecification = ((root, query, criteriaBuilder) ->
                accountFilterDto.getAccountName() == null || accountFilterDto.getAccountName().isBlank() ?
                        null : criteriaBuilder
                        .like(criteriaBuilder.upper(root.get("accountName")), accountFilterDto.getAccountName().toUpperCase()));

        Specification<Account> currencySpecification = ((root, query, criteriaBuilder) ->
                accountFilterDto.getCurrencyName() == null ?
                        null : criteriaBuilder.equal(criteriaBuilder.upper(root.get("currencyName")), accountFilterDto.getCurrencyName().name()));

        Specification<Account> clientSpecification = ((root, query, criteriaBuilder) -> {
            if (accountFilterDto.getClientId() == null) {
                return null;
            } else {
                Join<Account, Client> clientJoin = root.join("client");
                return criteriaBuilder.equal(clientJoin.get("id"), accountFilterDto.getClientId());
            }
        });

        Specification<Account> branchSpecification = ((root, query, criteriaBuilder) -> {
            if (accountFilterDto.getBranchId() == null) {
                return null;
            } else {
                Join<Account, Branch> branchJoin = root.join("branch");
                return criteriaBuilder.equal(branchJoin.get("id"), accountFilterDto.getBranchId());
            }
        });

        return Specification.where(accountNameSpecification)
                .or(currencySpecification)
                .or(clientSpecification)
                .or(branchSpecification);
    }



}
