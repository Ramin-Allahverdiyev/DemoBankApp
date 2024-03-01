package com.example.demoBankApp.repository;

import com.example.demoBankApp.dto.response.AccountResponse;
import com.example.demoBankApp.entity.Account;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    List<Account> findAll(Specification<Account> accountSpecification);

}
