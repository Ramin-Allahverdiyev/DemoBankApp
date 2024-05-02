package com.example.demoBankApp.service.impl;

import com.example.demoBankApp.entity.Client;
import com.example.demoBankApp.entity.Properties;
import com.example.demoBankApp.repository.ClientRepository;
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
    private final ClientRepository clientRepository;
    private final PropertiesRepository propertiesRepository;

    public List<Client> exportCustomerToExcel(HttpServletResponse response) throws IOException {
        List<Client> clients=clientRepository.findAll();
        ExcelExportUtils exportUtils=new ExcelExportUtils(clients,propertyService.getAllKeys(),propertiesRepository);
        exportUtils.exportDataToExcel(response);
        return clients;
    }

    public void saveExcelToDatabase(MultipartFile file){
        if (ExcelUploadService.isValidExcelFile(file)){
            try{
                List<Client> clients=ExcelUploadService.getClientsDataFromExcel(file.getInputStream());
                List<Properties> properties=ExcelUploadService.getPropertiesExcel(file.getInputStream());
                for (Client client : clients) {
                    List<Properties> clientProperties = properties.stream()
                            .filter(prop -> prop.getClient().equals(client))
                            .collect(Collectors.toList());
                    client.setPropertiesList(clientProperties);
                }
                clientRepository.saveAll(clients);
                propertiesRepository.saveAll(properties);
            }catch (IOException e){
                throw new IllegalArgumentException("Not a Valid Excel File");
            }

        }
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }




}
