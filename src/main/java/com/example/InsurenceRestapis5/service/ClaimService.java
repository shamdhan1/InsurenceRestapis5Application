package com.example.InsurenceRestapis5.service;

import com.example.InsurenceRestapis5.dto.ClaimResponseDTO;
import com.example.InsurenceRestapis5.dto.CreateClaimRequestDTO;

public interface ClaimService {
    ClaimResponseDTO addClaimToPolicy(Long policyId, CreateClaimRequestDTO dto);
}
