package com.example.soap.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.soap.api.loaneligibility.Acknowledgement;
import com.example.soap.api.loaneligibility.CustomerRequest;

@Service
public class LoanEligibilityService {
	
	public Acknowledgement checkLoanEligibility(CustomerRequest request) {
		
		Acknowledgement  acknowledgement = new Acknowledgement();
		List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();
		
		if(!(request.getAge()>30 && request.getAge()<=60)) {
			mismatchCriteriaList.add("person age should be in between 30 and 60");
		}
		if(!(request.getYearlyIncome()>200000)) {
			mismatchCriteriaList.add("person annual income should be greater than 2 lakhs");
		}
		if(!(request.getCibilScore()>500)) {
			mismatchCriteriaList.add("please try after 6 months");
		}
		
		if(mismatchCriteriaList.size()>0) {
			acknowledgement.setApprovedAmount(0);
			acknowledgement.setIsEligible(false);
		}else {
			acknowledgement.setApprovedAmount(500000);
			acknowledgement.setIsEligible(true);
		}
		
		return acknowledgement;
	}

}
