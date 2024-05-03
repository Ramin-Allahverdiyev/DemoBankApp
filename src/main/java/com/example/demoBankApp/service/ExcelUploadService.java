package com.example.demoBankApp.service;

import com.example.demoBankApp.entity.Client;
import com.example.demoBankApp.entity.Employee;
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


    public static List<Employee> getClientsDataFromExcel(InputStream inputStream){
        List<Employee> employeeList = new ArrayList<>();
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
                Employee employee = new Employee();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
//                    Cell colName=columnIterator.next();
                    switch (cellIndex){
                        case 0 -> employee.setId((int) cell.getNumericCellValue());
                        case 1 -> employee.setName(cell.getStringCellValue());
                        case 2 -> employee.setSurname(cell.getStringCellValue());
                        case 3 -> employee.setUsername(cell.getStringCellValue());
                        case 4 -> employee.setEmail(cell.getStringCellValue());
                        case 5 -> employee.setBirthDate(LocalDate.parse(cell.getStringCellValue(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                        default -> {
                        }
                    }
                    cellIndex++;

                    if (cellIndex==7)
                        break;
                }
                employeeList.add(employee);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return employeeList;
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
                Employee employee = new Employee();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    Cell colName=columnIterator.next();
                    String cellValue = cellValueAsString(cell);
                    switch (cellIndex){
                        case 0 -> employee.setId((int) cell.getNumericCellValue());
                        case 1 -> employee.setName(cell.getStringCellValue());
                        case 2 -> employee.setSurname(cell.getStringCellValue());
                        case 3 -> employee.setUsername(cell.getStringCellValue());
                        case 4 -> employee.setEmail(cell.getStringCellValue());
                        case 5 -> employee.setBirthDate(LocalDate.parse(cell.getStringCellValue(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                        default -> {
                            if(cellValue != null && !cellValue.equals("no")) {
                                propertiesList.add(Properties.builder()
                                        .employee(employee)
                                        .key(colName.getStringCellValue())
                                        .value(cellValue).build());
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
