package com.example.demoBankApp.service.impl;

import com.example.demoBankApp.entity.Client;
import com.example.demoBankApp.repository.ClientRepository;
import com.example.demoBankApp.repository.PropertiesRepository;
import com.example.demoBankApp.service.ExcelExportUtils;
import com.example.demoBankApp.service.PropertyService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelService {
    private final PropertyService propertyService;
    private final ClientRepository clientRepository;

    public List<Client> exportCustomerToExcel(HttpServletResponse response) throws IOException {
        List<Client> clients=clientRepository.findAll();
        ExcelExportUtils exportUtils=new ExcelExportUtils(clients,propertyService.getAllKeys());
        exportUtils.exportDataToExcel(response);
        return clients;
    }



}
