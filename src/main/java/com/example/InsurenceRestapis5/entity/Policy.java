package com.example.InsurenceRestapis5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity @Table(name="policies")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String policyNumber;

    @Enumerated(EnumType.STRING)
    private PolicyType type;

    @Enumerated(EnumType.STRING)
    private PolicyStatus status;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(mappedBy="policy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Claim> claims = new ArrayList<>();


}
