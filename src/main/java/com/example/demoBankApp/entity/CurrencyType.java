package com.example.demoBankApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CurrencyType {
    AZN("Manat"),
    USD("Dollar"),
    EUR("Avro");
    private final String name;


}
