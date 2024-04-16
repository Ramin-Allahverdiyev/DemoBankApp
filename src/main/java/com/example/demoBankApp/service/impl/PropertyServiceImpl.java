package com.example.demoBankApp.service.impl;

import com.example.demoBankApp.dto.request.PropertyRequest;
import com.example.demoBankApp.dto.response.PropertyResponse;
import com.example.demoBankApp.entity.Properties;
import com.example.demoBankApp.mapper.PropertyMapper;
import com.example.demoBankApp.repository.PropertiesRepository;
import com.example.demoBankApp.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final PropertiesRepository propertiesRepository;

    private static final Logger logger= LoggerFactory.getLogger(PropertyServiceImpl.class);

    @Override
    public Optional<PropertyResponse> saveProperty(PropertyRequest request) {
        logger.info("ActionLog.saveProperty.start request: {}",request);
        var properties = PropertyMapper.INSTANCE.dtoToEntity(request);
        var savedProperty = propertiesRepository.save(properties);
        var propertyResponse = PropertyMapper.INSTANCE.entityToDto(savedProperty);
        logger.info("ActionLog.saveProperty.end response: {}",propertyResponse);
        return Optional.of(propertyResponse);
    }

    @Override
    public List<String> getAllKeys() {
        List<Properties> propertiesList = propertiesRepository.findAll();
        return propertiesList.stream()
                .map(Properties::getKey)
                .collect(Collectors.toList());
    }

}
