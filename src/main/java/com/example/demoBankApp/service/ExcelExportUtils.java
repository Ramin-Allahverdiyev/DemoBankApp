package com.example.demoBankApp.service;

import com.example.demoBankApp.entity.Client;
import com.example.demoBankApp.entity.Properties;
import com.example.demoBankApp.repository.PropertiesRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ExcelExportUtils {
    private final XSSFWorkbook workbook;
    private final PropertiesRepository propertiesRepository;
    private XSSFSheet sheet;
    List<Client> clientList;
    Set<String> allKeys=new HashSet<>();



    public ExcelExportUtils(List<Client> clientList,Set<String> allKeys,PropertiesRepository propertiesRepository){
        this.clientList=clientList;
        this.allKeys=allKeys;
        this.propertiesRepository=propertiesRepository;
        workbook=new XSSFWorkbook();
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style){
        sheet.autoSizeColumn(columnCount);
        Cell cell=row.createCell(columnCount);
        if(value instanceof Integer){
            cell.setCellValue((Integer) value);
        }else if(value instanceof Double){
            cell.setCellValue((Double) value);
        }else if(value instanceof Boolean){
            cell.setCellValue((Boolean) value);
        }else if(value instanceof Long){
            cell.setCellValue((Long) value);
        }else{
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private  void createHeaderRow(){
        sheet=workbook.createSheet("Client Information");
        Row row = sheet.createRow(0);
        CellStyle style=workbook.createCellStyle();
        XSSFFont font=workbook.createFont();
        font.setBold(true);
        font.setFontHeight(20);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        createCell(row,0,"Client Information",style);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,7+allKeys.size()));
        font.setFontHeightInPoints((short) 10);

        row= sheet.createRow(1);
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row,0,"ID",style);
        createCell(row,1,"NAME",style);
        createCell(row,2,"SURNAME",style);
        createCell(row,3,"EMAIL",style);
        createCell(row,4,"USERNAME",style);
        createCell(row,5,"BIRTHDATE",style);
        createCell(row,6,"PHONE",style);
        int colCount=7;
        for (String col : allKeys) {
            createCell(row,colCount,col,style);
            colCount++;
        }
    }

    private void writeClientData(){
        int rowCount=2;
        CellStyle style=workbook.createCellStyle();
        XSSFFont font=workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for(Client client:clientList){
            Row row= sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row,columnCount++,client.getId(),style);
            createCell(row,columnCount++,client.getName(),style);
            createCell(row,columnCount++,client.getSurname(),style);
            createCell(row,columnCount++,client.getEmail(),style);
            createCell(row,columnCount++,client.getUsername(),style);
            createCell(row,columnCount++,client.getBirthDate().toString(),style);
            createCell(row,columnCount++,client.getPhone(),style);
            for (String s : allKeys) {
                Optional<Properties> propertyOfClient = propertiesRepository.findByKeyAndClient_Id(s, client.getId());
                if(propertyOfClient.isPresent()){
                    createCell(row,columnCount++,propertyOfClient.get().getValue(),style);
                }else {
                    createCell(row,columnCount++,null,style);
                }
            }
        }

    }

    public void exportDataToExcel(HttpServletResponse response) throws IOException {
        createHeaderRow();
        writeClientData();
        ServletOutputStream outputStream=response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }


}