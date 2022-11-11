package com.luma.service;

import java.util.Optional;

import com.luma.dto.EmployeeDto;
import com.luma.dto.LoginDto;

public interface EmployeeService {

	void registerUserToDb(EmployeeDto empDto) throws Exception;

	Optional<EmployeeDto> validateEmployee(LoginDto loginDto) throws Exception;

}