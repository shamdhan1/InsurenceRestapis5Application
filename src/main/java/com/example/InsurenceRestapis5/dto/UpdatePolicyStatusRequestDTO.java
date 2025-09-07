package com.example.InsurenceRestapis5.dto;

import com.example.InsurenceRestapis5.entity.PolicyStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdatePolicyStatusRequestDTO {

    @NotNull
    private PolicyStatus status;

}
