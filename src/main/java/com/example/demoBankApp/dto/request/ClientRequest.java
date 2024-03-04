package com.example.demoBankApp.dto.request;

import com.example.demoBankApp.Validation.constraint.ValidAge;
import com.example.demoBankApp.Validation.constraint.ValidEmail;
import com.example.demoBankApp.Validation.constraint.ValidPassword;
import com.example.demoBankApp.entity.AuthType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {
    private String name;
    private String surname;
    private String username;

    private String email;

    @ValidPassword
    private String password;

    @ValidAge
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Set<AuthType> authType;
    private String phone;
}
