package com.example.demoBankApp.service;

import com.example.demoBankApp.dto.request.EmployeeRequest;
import com.example.demoBankApp.dto.response.EmployeeResponse;

import java.util.Optional;

public interface EmployeeService {
    Optional<EmployeeResponse> saveEmployee(EmployeeRequest request);
}
