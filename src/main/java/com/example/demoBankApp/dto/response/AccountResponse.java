package com.example.demoBankApp.dto.response;

import com.example.demoBankApp.entity.CurrencyType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private Double amount;

    private String IBAN;

    private Integer branchId;

    private Integer clientId;

    @Enumerated(EnumType.STRING)
    private CurrencyType currencyName;

    private String accountName;

}
