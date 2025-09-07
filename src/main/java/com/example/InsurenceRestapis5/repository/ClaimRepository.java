package com.example.InsurenceRestapis5.repository;

import com.example.InsurenceRestapis5.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim,Long> {
}
