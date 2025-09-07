package com.example.InsurenceRestapis5.service;

import com.example.InsurenceRestapis5.dto.PolicyResponseDTO;
import com.example.InsurenceRestapis5.dto.UpdatePolicyStatusRequestDTO;
import com.example.InsurenceRestapis5.entity.Policy;
import com.example.InsurenceRestapis5.entity.PolicyStatus;
import com.example.InsurenceRestapis5.repository.PolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PolicyServiceImpl implements PolicyService{

    private final PolicyRepository policyRepository;


    @Override
    public PolicyResponseDTO updatePolicyStatus(Long policyid, UpdatePolicyStatusRequestDTO dto) {
        Policy p = policyRepository.findById(policyid).orElseThrow(() ->
                new RuntimeException("policy are not found "+policyid));
        p.setStatus(dto.getStatus());
        policyRepository.save(p);
        return new PolicyResponseDTO(p.getId(),p.getPolicyNumber(),p.getType(),p.getStatus());
    }


    @Override
    @Transactional(readOnly = true)
    public List<PolicyResponseDTO> getActivePolicies() {
        List<Policy> list = policyRepository.findByStatus(PolicyStatus.ACTIVE);
        return list.stream().map(p -> new PolicyResponseDTO(p.getId(),p.getPolicyNumber(),p.getType(),p.getStatus()))
                .collect(Collectors.toList());
    }


}
