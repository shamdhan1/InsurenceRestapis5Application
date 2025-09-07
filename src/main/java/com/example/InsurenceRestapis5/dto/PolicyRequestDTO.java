package com.example.InsurenceRestapis5.dto;

import com.example.InsurenceRestapis5.entity.PolicyType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PolicyRequestDTO {

    @NotBlank
    private String policyNumber;

    @NotNull
    private PolicyType type;

}
