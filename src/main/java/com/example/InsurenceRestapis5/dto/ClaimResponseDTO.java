package com.example.InsurenceRestapis5.dto;

import com.example.InsurenceRestapis5.entity.ClaimStatus;

import java.math.BigDecimal;

public record ClaimResponseDTO(Long id, String claimNumber, BigDecimal amount, ClaimStatus status) {
}
