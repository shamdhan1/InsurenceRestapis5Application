package com.example.InsurenceRestapis5.controller;


import com.example.InsurenceRestapis5.dto.ClaimResponseDTO;
import com.example.InsurenceRestapis5.dto.CreateClaimRequestDTO;
import com.example.InsurenceRestapis5.dto.PolicyResponseDTO;
import com.example.InsurenceRestapis5.dto.UpdatePolicyStatusRequestDTO;
import com.example.InsurenceRestapis5.service.ClaimService;
import com.example.InsurenceRestapis5.service.PolicyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
@RequiredArgsConstructor
public class PolicyController {

    private final PolicyService policyService;
    private final ClaimService claimService;

    @GetMapping("/active")
    public ResponseEntity<List<PolicyResponseDTO>> getActive(){
        return ResponseEntity.ok(policyService.getActivePolicies());
    }


    @PutMapping("/{id}/status")
    public ResponseEntity<PolicyResponseDTO> updateStatus(@PathVariable Long id,
                                                          @Valid
                                                          @RequestBody UpdatePolicyStatusRequestDTO dto){
        return ResponseEntity.ok(policyService.updatePolicyStatus(id, dto));
    }


    @PostMapping("/{id}/claims")
    public ResponseEntity<ClaimResponseDTO> addClaim(@PathVariable Long id,
                                                     @Valid
                                                     @RequestBody CreateClaimRequestDTO dto){
        return ResponseEntity.ok(claimService.addClaimToPolicy(id, dto));

    }

}
