package com.example.demoBankApp.mapper;

import com.example.demoBankApp.dto.request.AccountRequest;
import com.example.demoBankApp.dto.response.AccountResponse;
import com.example.demoBankApp.entity.Account;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        ,unmappedTargetPolicy = ReportingPolicy.IGNORE
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class AccountMapper {
    public static final AccountMapper INSTANCE= Mappers.getMapper(AccountMapper.class);
    @Mapping(target = "branch.id",source = "branchId")
    @Mapping(target = "client.id",source = "clientId")
    public abstract Account dtoToEntity(AccountRequest request);
    @Mapping(target = "branch.id",source = "branchId")
    @Mapping(target = "client.id",source = "clientId")
    public abstract void dtoToEntity(@MappingTarget Account account, AccountRequest request);
    @Mapping(target = "branchId",source = "branch.id")
    @Mapping(target = "clientId",source = "client.id")
    public abstract AccountResponse entityToDto(Account account);
    @Mapping(target = "branchId",source = "branch.id")
    @Mapping(target = "clientId",source = "client.id")
    public abstract List<AccountResponse> entityListToDtoList(List<Account> accounts);


}
