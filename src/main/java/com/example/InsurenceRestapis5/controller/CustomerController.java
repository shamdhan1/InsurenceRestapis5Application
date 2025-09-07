package com.example.InsurenceRestapis5.controller;


import com.example.InsurenceRestapis5.dto.CreateCustomerRequestDTO;
import com.example.InsurenceRestapis5.dto.CustomerResponseDTO;
import com.example.InsurenceRestapis5.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody CreateCustomerRequestDTO dto){
        return ResponseEntity.ok(customerService.createCustomer(dto));
    }

    // Feature 2
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomer(id));
    }




}
