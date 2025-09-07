package com.example.InsurenceRestapis5.dto;

import com.example.InsurenceRestapis5.entity.PolicyStatus;
import com.example.InsurenceRestapis5.entity.PolicyType;

public record PolicyResponseDTO(Long id, String policyNumber, PolicyType type, PolicyStatus status) {
}
