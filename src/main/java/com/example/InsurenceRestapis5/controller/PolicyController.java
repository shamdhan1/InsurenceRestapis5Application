package com.example.InsurenceRestapis5.controller;


import com.example.InsurenceRestapis5.dto.ClaimResponseDTO;
import com.example.InsurenceRestapis5.dto.CreateClaimRequestDTO;
import com.example.InsurenceRestapis5.dto.PolicyResponseDTO;
import com.example.InsurenceRestapis5.dto.UpdatePolicyStatusRequestDTO;
import com.example.InsurenceRestapis5.service.ClaimService;
import com.example.InsurenceRestapis5.service.PolicyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
@RequiredArgsConstructor
@Slf4j
public class PolicyController {

    private final PolicyService policyService;
    private final ClaimService claimService;

    @GetMapping("/active")
    public ResponseEntity<List<PolicyResponseDTO>> getActive() {
        log.info("Fetching all active policies...");
        List<PolicyResponseDTO> activePolicies = policyService.getActivePolicies();
        log.info("Total active policies fetched={}", activePolicies.size());
        return ResponseEntity.ok(activePolicies);
    }


    @PutMapping("/{id}/status")
    public ResponseEntity<PolicyResponseDTO> updateStatus(@PathVariable Long id,
                                                          @Valid @RequestBody UpdatePolicyStatusRequestDTO dto) {
        log.info("Request received to update status of policyId={} to {}", id, dto.getStatus());
        PolicyResponseDTO updatedPolicy = policyService.updatePolicyStatus(id, dto);
        log.info("Policy id={} updated successfully to status={}", id, updatedPolicy.status());
        return ResponseEntity.ok(updatedPolicy);
    }


    @PostMapping("/{id}/claims")
    public ResponseEntity<ClaimResponseDTO> addClaim(@PathVariable Long id,
                                                     @Valid @RequestBody CreateClaimRequestDTO dto) {
        log.info("Adding claim to policyId={} with and amount={}",id, dto.getAmount());
        ClaimResponseDTO claimResponse = claimService.addClaimToPolicy(id, dto);
        log.info("Claim created successfully with claimId={} for policyId={}", claimResponse.id(), id);
        return ResponseEntity.status(HttpStatus.CREATED).body(claimResponse);
    }

}
