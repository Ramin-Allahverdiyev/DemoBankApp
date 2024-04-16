package com.example.demoBankApp.mapper;

import com.example.demoBankApp.dto.request.PropertyRequest;
import com.example.demoBankApp.dto.response.PropertyResponse;
import com.example.demoBankApp.entity.Properties;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        ,unmappedTargetPolicy = ReportingPolicy.IGNORE
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PropertyMapper {
    public static final PropertyMapper INSTANCE= Mappers.getMapper(PropertyMapper.class);
    @Mapping(target = "client.id",source = "clientId")
    public abstract Properties dtoToEntity(PropertyRequest request);
    @Mapping(target = "client.id",source = "clientId")
    public abstract void dtoToEntity(@MappingTarget Properties properties, PropertyRequest request);
    @Mapping(target = "clientId",source = "client.id")
    public abstract PropertyResponse entityToDto(Properties properties);
    @Mapping(target = "clientId",source = "client.id")
    public abstract List<PropertyResponse> entityListToDtoList(List<Properties> properties);


}
