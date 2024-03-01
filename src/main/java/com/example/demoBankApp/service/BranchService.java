package com.example.demoBankApp.service;

import com.example.demoBankApp.dto.request.BranchRequest;
import com.example.demoBankApp.dto.response.BranchResponse;


import java.util.Optional;

public interface BranchService {
    Optional<BranchResponse> saveBranch(BranchRequest request);

}
