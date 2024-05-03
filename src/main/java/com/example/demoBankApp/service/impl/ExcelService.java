package com.example.demoBankApp.service.impl;

import com.example.demoBankApp.entity.Client;
import com.example.demoBankApp.entity.Employee;
import com.example.demoBankApp.entity.Properties;
import com.example.demoBankApp.repository.ClientRepository;
import com.example.demoBankApp.repository.EmployeeRepository;
import com.example.demoBankApp.repository.PropertiesRepository;
import com.example.demoBankApp.service.ExcelExportUtils;
import com.example.demoBankApp.service.ExcelUploadService;
import com.example.demoBankApp.service.PropertyService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExcelService {
    private final PropertyService propertyService;
    private final EmployeeRepository employeeRepository;
    private final PropertiesRepository propertiesRepository;

    public List<Employee> exportCustomerToExcel(HttpServletResponse response) throws IOException {
        List<Employee> employees=employeeRepository.findAll();
        ExcelExportUtils exportUtils=new ExcelExportUtils(employees,propertyService.getAllKeys(),propertiesRepository);
        exportUtils.exportDataToExcel(response);
        return employees;
    }

    public void saveExcelToDatabase(MultipartFile file){
        if (ExcelUploadService.isValidExcelFile(file)){
            try{
                List<Employee> employees=ExcelUploadService.getClientsDataFromExcel(file.getInputStream());
                List<Properties> properties=ExcelUploadService.getPropertiesExcel(file.getInputStream());
                for (Employee employee : employees) {
                    List<Properties> clientProperties = properties.stream()
                            .filter(prop -> prop.getEmployee().equals(employee))
                            .collect(Collectors.toList());
                    employee.setPropertiesList(clientProperties);
                }
                employeeRepository.saveAll(employees);
                propertiesRepository.saveAll(properties);
            }catch (IOException e){
                throw new IllegalArgumentException("Not a Valid Excel File");
            }

        }
    }


}
