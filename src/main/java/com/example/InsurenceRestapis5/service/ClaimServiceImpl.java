package com.example.InsurenceRestapis5.service;


import com.example.InsurenceRestapis5.dto.ClaimResponseDTO;
import com.example.InsurenceRestapis5.dto.CreateClaimRequestDTO;
import com.example.InsurenceRestapis5.entity.Claim;
import com.example.InsurenceRestapis5.entity.ClaimStatus;
import com.example.InsurenceRestapis5.entity.Policy;
import com.example.InsurenceRestapis5.repository.ClaimRepository;
import com.example.InsurenceRestapis5.repository.PolicyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClaimServiceImpl implements ClaimService {

    private final PolicyRepository policyRepository;
    private final ClaimRepository claimRepository;


    @Override
    @Transactional
    public ClaimResponseDTO addClaimToPolicy(Long policyId, CreateClaimRequestDTO dto) {

        Policy p = policyRepository.findById(policyId).orElseThrow(() ->
                new RuntimeException("policy are not found" + policyId));
        Claim c = new Claim();
        c.setAmount(dto.getAmount());
        c.setPolicy(p);
        c.setStatus(ClaimStatus.FILED);
        c.setClaimNumber("CLM-" + UUID.randomUUID().toString().substring(0,8));
        Claim saved = claimRepository.save(c);

        p.getClaims().add(saved);
        policyRepository.save(p);

        return new ClaimResponseDTO(saved.getId(), saved.getClaimNumber(), saved.getAmount(), saved.getStatus());

    }
}
