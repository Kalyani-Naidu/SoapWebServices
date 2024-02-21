package com.example.soap.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.soap.api.loaneligibility.Acknowledgement;
import com.example.soap.api.loaneligibility.CustomerRequest;
import com.example.soap.api.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityEndpoint {
	
	@Autowired
	private LoanEligibilityService service;

	public static final String NAMESPACE = "http://www.example.com/soap/api/LoanEligibility";
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkLoanEligibility(request);
	}
	
}
