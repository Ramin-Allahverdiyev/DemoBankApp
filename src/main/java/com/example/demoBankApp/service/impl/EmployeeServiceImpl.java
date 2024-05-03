package com.example.demoBankApp.service.impl;

import com.example.demoBankApp.dto.request.EmployeeRequest;
import com.example.demoBankApp.dto.response.EmployeeResponse;
import com.example.demoBankApp.mapper.BranchMapper;
import com.example.demoBankApp.mapper.EmployeeMapper;
import com.example.demoBankApp.repository.EmployeeRepository;
import com.example.demoBankApp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger logger= LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeRepository employeeRepository;
    @Override
    public Optional<EmployeeResponse> saveEmployee(EmployeeRequest request) {
        logger.info("ActionLog.saveEmployee.start request: {}",request);
        var employee = EmployeeMapper.INSTANCE.dtoToEntity(request);
        var savedEmployee = employeeRepository.save(employee);
        var response=EmployeeMapper.INSTANCE.entityToDto(savedEmployee);
        logger.info("ActionLog.saveEmployee.stop response: {}",response);
        return Optional.of(response);
    }
}
