package com.example.demoBankApp.dto.response;

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
public class EmployeeResponse {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String username;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
}
