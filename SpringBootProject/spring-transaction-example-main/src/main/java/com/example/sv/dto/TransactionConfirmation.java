package com.example.sv.dto;

import com.example.sv.entity.CustomerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionConfirmation {

    private String status;
    private double amount;
    private CustomerInfo customerInfo;
    
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public TransactionConfirmation(String status, double amount, CustomerInfo customerInfo) {
		super();
		this.status = status;
		this.amount = amount;
		this.customerInfo = customerInfo;
	}
    
}
