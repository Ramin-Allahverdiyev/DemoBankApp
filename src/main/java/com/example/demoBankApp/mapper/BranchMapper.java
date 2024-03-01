package com.example.demoBankApp.mapper;

import com.example.demoBankApp.dto.request.BranchRequest;
import com.example.demoBankApp.dto.request.ClientRequest;
import com.example.demoBankApp.dto.response.BranchResponse;
import com.example.demoBankApp.dto.response.ClientResponse;
import com.example.demoBankApp.entity.Branch;
import com.example.demoBankApp.entity.Client;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        ,unmappedTargetPolicy = ReportingPolicy.IGNORE
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class BranchMapper {
    public static final BranchMapper INSTANCE= Mappers.getMapper(BranchMapper.class);

    public abstract Branch dtoToEntity(BranchRequest request);

    public abstract void dtoToEntity(@MappingTarget Branch branch, BranchRequest request);
    public abstract BranchResponse entityToDto(Branch branch);

    public abstract List<BranchResponse> entityListToDtoList(List<Branch> branches);
}
