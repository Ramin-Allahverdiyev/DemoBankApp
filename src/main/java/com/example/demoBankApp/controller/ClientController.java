package com.example.demoBankApp.controller;

import com.example.demoBankApp.dto.request.ClientRequest;
import com.example.demoBankApp.dto.response.ClientResponse;
import com.example.demoBankApp.service.ClientService;
import com.example.demoBankApp.service.impl.ExcelService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/client")
public class ClientController {
    private final ClientService clientService;
    private final ExcelService excelService;

    @PostMapping("/register")
    public Optional<ClientResponse> registerClient(@RequestBody @Valid ClientRequest request){
        return clientService.registerClient(request);
    }

    @GetMapping("/all")
    public Page<ClientResponse> findAllByPage(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "2") int sizePerPage,
                                              @RequestParam(defaultValue = "ID") String sortField,
                                              @RequestParam(defaultValue = "DESC") Sort.Direction sortDirection) {
        Pageable pageable = PageRequest.of(page, sizePerPage, sortDirection, sortField.toLowerCase());
        return clientService.findAllByPage(pageable);
    }

    @GetMapping("/export-to-excel")
    public void exportToExcel(HttpServletResponse response) throws IOException{
        response.setContentType("application/octet-stream");
        String headerKey="Content-Disposition";
        String headerValue = "attachment; filename=Client_info.xlsx";
        response.setHeader(headerKey,headerValue);
        excelService.exportCustomerToExcel(response);
    }

    @RequestMapping(
            path = "/upload",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadExcelToDb(@RequestParam("file")MultipartFile file){
        excelService.saveExcelToDatabase(file);
        return ResponseEntity.ok(Map.of("Message", "Data uploaded sand saved to database!"));
    }

}
