package com.example.demoBankApp.mapper;

import com.example.demoBankApp.dto.request.ClientRequest;
import com.example.demoBankApp.dto.response.ClientResponse;
import com.example.demoBankApp.entity.Client;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        ,unmappedTargetPolicy = ReportingPolicy.IGNORE
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class ClientMapper {
    public static final ClientMapper INSTANCE= Mappers.getMapper(ClientMapper.class);

    public abstract Client dtoToEntity(ClientRequest request);

    public abstract void dtoToEntity(@MappingTarget Client client, ClientRequest request);
    public abstract ClientResponse entityToDto(Client client);

    public abstract List<ClientResponse> entityListToDtoList(List<Client> clients);
}
