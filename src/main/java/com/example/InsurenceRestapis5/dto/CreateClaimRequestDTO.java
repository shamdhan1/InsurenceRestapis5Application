package com.example.InsurenceRestapis5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CreateClaimRequestDTO {

    @NotNull
    private BigDecimal amount;


}

