package com.example.InsurenceRestapis5.controller;


import com.example.InsurenceRestapis5.dto.CreateCustomerRequestDTO;
import com.example.InsurenceRestapis5.dto.CustomerResponseDTO;
import com.example.InsurenceRestapis5.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody CreateCustomerRequestDTO dto) {
        log.info("Received request to create customer with name={} and email={}", dto.getName(), dto.getEmail());
        CustomerResponseDTO response = customerService.createCustomer(dto);
        log.info("Customer created successfully with id={}", response.id());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable Long id) {
        log.info("Fetching customer with id={}", id);
        CustomerResponseDTO response = customerService.getCustomer(id);
        log.info("Successfully fetched customer id={} with name={}", response.id(), response.name());
        return ResponseEntity.ok(response);
    }


}
