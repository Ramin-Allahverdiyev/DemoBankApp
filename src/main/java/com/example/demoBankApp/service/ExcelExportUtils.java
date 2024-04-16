package com.example.demoBankApp.service;

import com.example.demoBankApp.entity.Client;
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
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class ExcelExportUtils {
    private final XSSFWorkbook workbook;
    private XSSFSheet sheet;
    List<Client> clientList;
    List<String> allKeys;


    public ExcelExportUtils(List<Client> clientList,List<String> allKeys){
        this.clientList=clientList;
        this.allKeys=allKeys;
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
        createCell(row,0,"NAME",style);
        createCell(row,0,"SURNAME",style);
        createCell(row,0,"EMAIL",style);
        createCell(row,0,"USERNAME",style);
        createCell(row,0,"BIRTHDATE",style);
        createCell(row,0,"PHONE",style);
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
            createCell(row,columnCount++,client.getId(),style);
            createCell(row,columnCount++,client.getId(),style);
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
