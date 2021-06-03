package com.example.sv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sv.entity.CustomerInfo;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo,Long> {
}
