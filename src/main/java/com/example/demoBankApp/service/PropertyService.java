package com.example.demoBankApp.service;

import com.example.demoBankApp.dto.request.PropertyRequest;
import com.example.demoBankApp.dto.response.PropertyResponse;

import java.util.List;
import java.util.Optional;

public interface PropertyService {
    Optional<PropertyResponse> saveProperty(PropertyRequest request);
    List<String> getAllKeys();
}
