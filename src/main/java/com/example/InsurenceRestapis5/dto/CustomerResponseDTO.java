package com.example.InsurenceRestapis5.dto;

import java.util.List;

public record CustomerResponseDTO(Long id, String name, String email, List<PolicyResponseDTO> policies) {
}
