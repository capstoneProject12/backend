package com.luma.service;

import java.util.List;

import com.luma.dto.ApplyLoanDto;
import com.luma.dto.LoansListDto;

public interface LoanService {

	List<LoansListDto> getLoansByEmpId(String employeeId);

	void applyForLoan(ApplyLoanDto applyLoanDto) throws Exception;
}