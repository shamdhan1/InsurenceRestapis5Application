package com.example.InsurenceRestapis5.service;


import com.example.InsurenceRestapis5.dto.CreateCustomerRequestDTO;
import com.example.InsurenceRestapis5.dto.CustomerResponseDTO;
import com.example.InsurenceRestapis5.dto.PolicyRequestDTO;
import com.example.InsurenceRestapis5.dto.PolicyResponseDTO;
import com.example.InsurenceRestapis5.entity.Customer;
import com.example.InsurenceRestapis5.entity.Policy;
import com.example.InsurenceRestapis5.entity.PolicyStatus;
import com.example.InsurenceRestapis5.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;


    @Override
    @Transactional
    public CustomerResponseDTO createCustomer(CreateCustomerRequestDTO dto) {

        // map top-level fields
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());

        // map policies manually to set back-reference and defaults

        if(dto.getPolicies()!=null){
            for(PolicyRequestDTO p : dto.getPolicies()){
                Policy policy = new Policy();
                policy.setPolicyNumber(p.getPolicyNumber());
                policy.setType(p.getType());
                policy.setStatus(PolicyStatus.ACTIVE);
                policy.setCustomer(customer);
                customer.getPolicies().add(policy);
            }
        }
        Customer saved = customerRepository.save(customer);
        // map to response (manual mapping to use records)
        List<PolicyResponseDTO> policies = saved.getPolicies().stream()
                .map(p -> new PolicyResponseDTO(p.getId(),
                        p.getPolicyNumber(), p.getType(),
                        p.getStatus()))
                .collect(Collectors.toList());
        return new CustomerResponseDTO(saved.getId(), saved.getName(), saved.getEmail(), policies);
    }

    @Override
    public CustomerResponseDTO getCustomer(Long id){
        Customer c = customerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Customer not found: " + id));
        List<PolicyResponseDTO> policies = c.getPolicies().stream()
                .map(p -> new PolicyResponseDTO(p.getId(), p.getPolicyNumber(), p.getType(), p.getStatus()))
                .collect(Collectors.toList());
        return new CustomerResponseDTO(c.getId(), c.getName(), c.getEmail(), policies);
    }


}
