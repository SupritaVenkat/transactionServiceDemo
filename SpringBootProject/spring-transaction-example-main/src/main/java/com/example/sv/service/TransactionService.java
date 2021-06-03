package com.example.sv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sv.dto.TransactionConfirmation;
import com.example.sv.dto.TransactionRequest;
import com.example.sv.entity.CustomerInfo;
import com.example.sv.entity.PaymentInfo;
import com.example.sv.repository.CustomerInfoRepository;
import com.example.sv.repository.PaymentInfoRepository;
import com.example.sv.utils.PaymentUtils;

@Service
public class TransactionService {

    @Autowired
    private CustomerInfoRepository customerInfoRepository;
    
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional
    public TransactionConfirmation makePayment(TransactionRequest request) {

        CustomerInfo customerInfo = request.getCustomerInfo();
        customerInfo = customerInfoRepository.save(customerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimitorDebitBal(paymentInfo.getAccountNo(), customerInfo.getAmount());
        double remBal = PaymentUtils.remainingBalance(paymentInfo.getAccountNo(),customerInfo.getAmount());
        paymentInfo.setCustomerId(customerInfo.getcId());
        paymentInfo.setAmount(customerInfo.getAmount());
        paymentInfoRepository.save(paymentInfo);
        return new TransactionConfirmation("SUCCESS",remBal,customerInfo);

    }
}
