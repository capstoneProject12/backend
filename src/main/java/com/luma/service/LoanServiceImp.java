package com.luma.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.luma.dto.ApplyLoanDto;
import com.luma.dto.LoansListDto;
import com.luma.entity.*;
import com.luma.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImp implements LoanService {
	
	@Autowired
	LoanCardRepo loanRepo;

	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private ItemRepo itemRepo;

	@Autowired
	private EmployeeCardEntityRepo empCardEntityRepo;

	@Autowired
	private EmployeeIssueEntityRepo empIssueEntityRepo;
	
	@Override
	public List<LoansListDto> getLoansByEmpId(String employeeId) {
		List<LoansListDto> loanList = new ArrayList<>();
		for(List<String> row : loanRepo.getLoansByEmpId(employeeId)) {
			LoansListDto loan = new LoansListDto();
			loan.setLoan_id(Long.parseLong(row.get(0)));
			loan.setLoan_type(row.get(1));
			loan.setDuration_in_years(Integer.parseInt(row.get(2)));
			try {
				loan.setCard_issue_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(row.get(3)));
			} catch (ParseException e) {
				loan.setCard_issue_date(null);
			}
			loanList.add(loan);
		}
		return loanList;
	}

	@Override
	public void applyForLoan(ApplyLoanDto applyLoanDto) throws Exception{

		Optional<EmployeeMasterEntity> employee = empRepo.findById(applyLoanDto.getEmployeeId());
		Optional<LoanCardEntity> loan = Optional.ofNullable(loanRepo.getLoansByItemCategory(applyLoanDto.getItem_category()));
		Optional<ItemEntity> item = itemRepo.findById(applyLoanDto.getItem_id());
		System.out.println(loan.get());
		if(employee.isPresent() && item.isPresent() && loan.isPresent()) {

			//working
			EmployeeMasterEntity employeeEntity = employee.get();
			LoanCardEntity loanEntity = loan.get();
			ItemEntity itemEntity = item.get();

			EmployeeCardEntity employeeCardEntity = new EmployeeCardEntity();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
			employeeCardEntity.setCard_issue_date(new Date());
			employeeCardEntity.setLoanCardEntity(loanEntity);
			employeeCardEntity.setEmployeeMasterEntity(employeeEntity);
			empCardEntityRepo.save(employeeCardEntity);

			EmployeeIssueEntity employeeIssueEntity = new EmployeeIssueEntity();
			employeeIssueEntity.setIssue_date(new Date());
			employeeIssueEntity.setItemEntity(itemEntity);
			employeeIssueEntity.setEmployeeMasterEntity(employeeEntity);
			empIssueEntityRepo.save(employeeIssueEntity);
			return;
		}
		else {
			System.out.println("invalid details passed");
			throw new Exception("Please enter correct details");
		}
	}

}
