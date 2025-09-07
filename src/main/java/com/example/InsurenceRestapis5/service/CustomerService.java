package com.example.InsurenceRestapis5.service;
import com.example.InsurenceRestapis5.dto.CreateCustomerRequestDTO;
import com.example.InsurenceRestapis5.dto.CustomerResponseDTO;

public interface CustomerService {

    CustomerResponseDTO createCustomer(CreateCustomerRequestDTO dto);
    CustomerResponseDTO getCustomer(Long id);
}
