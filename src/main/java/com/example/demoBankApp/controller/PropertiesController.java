package com.example.demoBankApp.controller;

import com.example.demoBankApp.dto.request.PropertyRequest;
import com.example.demoBankApp.dto.response.PropertyResponse;
import com.example.demoBankApp.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/property")
public class PropertiesController {
    private final PropertyService propertyService;

    @PostMapping("/save")
    public Optional<PropertyResponse> registerUser(@RequestBody PropertyRequest request){
        return propertyService.saveProperty(request);
    }

}
