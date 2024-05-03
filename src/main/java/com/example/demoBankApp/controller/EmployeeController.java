package com.example.demoBankApp.controller;

import com.example.demoBankApp.dto.request.BranchRequest;
import com.example.demoBankApp.dto.request.EmployeeRequest;
import com.example.demoBankApp.dto.response.BranchResponse;
import com.example.demoBankApp.dto.response.EmployeeResponse;
import com.example.demoBankApp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/save")
    public Optional<EmployeeResponse> registerUser(@RequestBody EmployeeRequest request){
        return employeeService.saveEmployee(request);
    }

}
