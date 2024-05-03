package com.example.demoBankApp.dto.request;

import com.example.demoBankApp.Validation.constraint.ValidAge;
import com.example.demoBankApp.Validation.constraint.ValidEmail;
import com.example.demoBankApp.Validation.constraint.ValidPassword;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    private String name;
    private String surname;
    private String username;
    @ValidEmail
    private String email;

    @ValidAge
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
}
