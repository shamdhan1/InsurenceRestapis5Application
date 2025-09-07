package com.example.InsurenceRestapis5.service;

import com.example.InsurenceRestapis5.dto.PolicyRequestDTO;
import com.example.InsurenceRestapis5.dto.PolicyResponseDTO;
import com.example.InsurenceRestapis5.dto.UpdatePolicyStatusRequestDTO;

import java.util.List;

public interface PolicyService {

    PolicyResponseDTO updatePolicyStatus(Long policyid, UpdatePolicyStatusRequestDTO dto);
    List<PolicyResponseDTO>  getActivePolicies();
}
