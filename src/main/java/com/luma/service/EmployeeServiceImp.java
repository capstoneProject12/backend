package com.luma.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luma.dto.EmployeeDto;
import com.luma.dto.LoginDto;
import com.luma.entity.EmployeeMasterEntity;
import com.luma.repository.EmployeeRepo;
import com.luma.utility.EmployeeDtoConverter;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public void registerUserToDb(EmployeeDto empDto) throws Exception {
		Optional<EmployeeMasterEntity> employeeMaster = empRepo.findById(empDto.getEmployeeId());
		System.out.println(empDto);
		if(employeeMaster.isPresent()) {
			System.out.println("User with Empid already exists!");
			throw new Exception("User with Empid already exists!");
			
		}
		else {
			EmployeeMasterEntity employee = EmployeeDtoConverter.getEmployeeEntity(empDto);
			empRepo.save(employee);
			empRepo.flush();
		}
	}

	@Override
	public Optional<EmployeeDto> validateEmployee(LoginDto loginDto) throws Exception {
		Optional<EmployeeMasterEntity> employee = empRepo.findById(loginDto.getEmployeeId());
		if(employee.isPresent() && employee.get().getPassword().equals(loginDto.getPassword())) {
			System.out.println("Login Success");
			return Optional.of(EmployeeDtoConverter.getEmployeeDto(employee.get()));
		}
		else {
			System.out.println("Login Failed");
			throw new Exception("invalid credentials");
		}
	}
	
	
}
