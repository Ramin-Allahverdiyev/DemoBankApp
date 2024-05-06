package com.example.demoBankApp.mapper;

import com.example.demoBankApp.dto.request.BranchRequest;
import com.example.demoBankApp.dto.response.BranchResponse;
import com.example.demoBankApp.entity.Branch;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T09:55:15+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
public class BranchMapperImpl extends BranchMapper {

    @Override
    public Branch dtoToEntity(BranchRequest request) {
        if ( request == null ) {
            return null;
        }

        Branch.BranchBuilder branch = Branch.builder();

        if ( request.getName() != null ) {
            branch.name( request.getName() );
        }
        if ( request.getCode() != null ) {
            branch.code( request.getCode() );
        }

        return branch.build();
    }

    @Override
    public void dtoToEntity(Branch branch, BranchRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getName() != null ) {
            branch.setName( request.getName() );
        }
        if ( request.getCode() != null ) {
            branch.setCode( request.getCode() );
        }
    }

    @Override
    public BranchResponse entityToDto(Branch branch) {
        if ( branch == null ) {
            return null;
        }

        BranchResponse.BranchResponseBuilder branchResponse = BranchResponse.builder();

        if ( branch.getName() != null ) {
            branchResponse.name( branch.getName() );
        }
        if ( branch.getCode() != null ) {
            branchResponse.code( branch.getCode() );
        }

        return branchResponse.build();
    }

    @Override
    public List<BranchResponse> entityListToDtoList(List<Branch> branches) {
        if ( branches == null ) {
            return null;
        }

        List<BranchResponse> list = new ArrayList<BranchResponse>( branches.size() );
        for ( Branch branch : branches ) {
            list.add( entityToDto( branch ) );
        }

        return list;
    }
}
