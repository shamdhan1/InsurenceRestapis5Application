package com.example.InsurenceRestapis5.repository;

import com.example.InsurenceRestapis5.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
