package com.example.demoBankApp.service.impl;

import com.example.demoBankApp.dto.request.BranchRequest;
import com.example.demoBankApp.dto.response.BranchResponse;
import com.example.demoBankApp.entity.AuthType;
import com.example.demoBankApp.entity.Authority;
import com.example.demoBankApp.mapper.BranchMapper;
import com.example.demoBankApp.mapper.ClientMapper;
import com.example.demoBankApp.repository.BranchRepository;
import com.example.demoBankApp.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;
    private static final Logger logger= LoggerFactory.getLogger(BranchServiceImpl.class);
    @Override
    public Optional<BranchResponse> saveBranch(BranchRequest request) {
        logger.info("ActionLog.saveBranch.start request: {}",request);
        var branch = BranchMapper.INSTANCE.dtoToEntity(request);
        var savedBranch = branchRepository.save(branch);
        var response=BranchMapper.INSTANCE.entityToDto(savedBranch);
        logger.info("ActionLog.saveBranch.stop response: {}",response);
        return Optional.of(response);
    }
}
