package com.example.demoBankApp.service;

import com.example.demoBankApp.dto.request.PropertyRequest;
import com.example.demoBankApp.dto.response.PropertyResponse;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PropertyService {
    Optional<PropertyResponse> saveProperty(PropertyRequest request);

    Set<String> getAllKeys();
}
