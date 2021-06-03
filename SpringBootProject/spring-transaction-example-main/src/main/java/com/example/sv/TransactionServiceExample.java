package com.example.sv;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.sv.dto.TransactionConfirmation;
import com.example.sv.dto.TransactionRequest;
import com.example.sv.service.TransactionService;


@SpringBootApplication
@RestController
@EnableTransactionManagement
@ComponentScan
public class TransactionServiceExample {

	@Autowired
	private TransactionService service;


	@PostMapping("/cardTransaction")
	public TransactionConfirmation makePayment(@Valid @RequestBody TransactionRequest request){
		return service.makePayment(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(TransactionServiceExample.class, args);
	}

}
