package com.example.sv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sv.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,Long> {
}
