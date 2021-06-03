package com.example.sv.utils;

import java.util.HashMap;
import java.util.Map;

import com.example.sv.exception.InsufficientAmountException;

public class PaymentUtils {

    private static Map<String, Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("acc1", 12000.0);
        paymentMap.put("acc2", 10000.0);
        paymentMap.put("acc3", 5000.0);
        paymentMap.put("acc4", 18000.0);
    }


    public static boolean validateCreditLimitorDebitBal(String accNo, double paidAmount) {
        if (paidAmount > paymentMap.get(accNo)) {
            throw new InsufficientAmountException("insufficient fund for the transaction!");
        } else {
        	
            return true;
        }
    }
    
    public static double remainingBalance(String accNo,double paidAmount){
    	return paymentMap.get(accNo)- paidAmount;
    }
}
