package com.example.InsurenceRestapis5.repository;

import com.example.InsurenceRestapis5.entity.Policy;
import com.example.InsurenceRestapis5.entity.PolicyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy,Long> {
    List<Policy> findByStatus(PolicyStatus status);
}
