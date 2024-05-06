package com.example.demoBankApp.mapper;

import com.example.demoBankApp.dto.request.ClientRequest;
import com.example.demoBankApp.dto.request.EmployeeRequest;
import com.example.demoBankApp.dto.response.ClientResponse;
import com.example.demoBankApp.dto.response.EmployeeResponse;
import com.example.demoBankApp.entity.Client;
import com.example.demoBankApp.entity.Employee;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        ,unmappedTargetPolicy = ReportingPolicy.IGNORE
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class EmployeeMapper {
    public static final EmployeeMapper INSTANCE= Mappers.getMapper(EmployeeMapper.class);

    public abstract Employee dtoToEntity(EmployeeRequest request);

    public abstract void dtoToEntity(@MappingTarget Employee employee, EmployeeRequest request);
    public abstract EmployeeResponse entityToDto(Employee employee);

    public abstract List<EmployeeResponse> entityListToDtoList(List<Employee> employees);
}
