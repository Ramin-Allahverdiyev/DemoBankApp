package com.example.demoBankApp.service;

import com.example.demoBankApp.entity.Client;
import com.example.demoBankApp.entity.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ExcelUploadService {
    public static boolean isValidExcelFile(MultipartFile file){
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" );
    }

    public static String cellValueAsString(Cell cell) {
        if (cell == null) {
            return "no"; // Return "no" if the cell is null
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "no"; // Return "no" for other cell types
        }
    }


    public static List<Client> getClientsDataFromExcel(InputStream inputStream){
        List<Client> clientList = new ArrayList<>();
        List<Properties> propertiesList = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Client Information");
            Row rowCol= sheet.getRow(1);
//            Iterator<Cell> columnIterator= rowCol.iterator();
            int rowIndex =0;
            for (Row row : sheet){
                if (rowIndex <=1){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                Client client = new Client();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
//                    Cell colName=columnIterator.next();
                    switch (cellIndex){
                        case 0 -> client.setId((int) cell.getNumericCellValue());
                        case 1 -> client.setName(cell.getStringCellValue());
                        case 2 -> client.setSurname(cell.getStringCellValue());
                        case 3 -> client.setEmail(cell.getStringCellValue());
                        case 4 -> client.setUsername(cell.getStringCellValue());
                        case 5 -> client.setBirthDate(LocalDate.parse(cell.getStringCellValue(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                        case 6 -> client.setPhone(cellValueAsString(cell));
                        default -> {
                        }
                    }
                    cellIndex++;

                    if (cellIndex==7)
                        break;
                }
                clientList.add(client);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return clientList;
    }

    public static List<Properties> getPropertiesExcel(InputStream inputStream){
        List<Properties> propertiesList = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Client Information");
            Row rowCol= sheet.getRow(1);
            int rowIndex =0;
            for (Row row : sheet){
                if (rowIndex <=1){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                Iterator<Cell> columnIterator= rowCol.iterator();
                int cellIndex = 0;
                Client client = new Client();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    Cell colName=columnIterator.next();
                    String cellValue = cellValueAsString(cell);
                    switch (cellIndex){
                        case 0 -> client.setId((int) cell.getNumericCellValue());
                        case 1 -> client.setName(cell.getStringCellValue());
                        case 2 -> client.setSurname(cell.getStringCellValue());
                        case 3 -> client.setEmail(cell.getStringCellValue());
                        case 4 -> client.setUsername(cell.getStringCellValue());
                        case 5 -> client.setBirthDate(LocalDate.parse(cell.getStringCellValue(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                        case 6 -> client.setPhone(cellValueAsString(cell));
                        default -> {
                            if (cellValue != null && !cellValue.equals("no")) {
                                String key = colName.getStringCellValue().trim(); // Use column name as key
                                // Check if the property already exists for this client
                                if (!isPropertyExists(client, key, cellValue)) {
                                    propertiesList.add(Properties.builder()
                                            .client(client)
                                            .key(key)
                                            .value(cellValue)
                                            .build());
                                }
                            }
                        }
                    }


                    cellIndex++;
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return propertiesList;
    }

    private static boolean isPropertyExists(Client client, String key, String value) {
        // Check if a similar property already exists in the database for this client
        Optional<Properties> existingProperty = client.getPropertiesList().stream()
                .filter(prop -> prop.getKey().equals(key) && prop.getValue().equals(value))
                .findFirst();

        return existingProperty.isPresent();
    }


}
