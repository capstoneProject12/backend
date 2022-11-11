package com.luma.utility;

import com.luma.dto.EmployeeDto;
import com.luma.entity.EmployeeMasterEntity;

public class EmployeeDtoConverter {
	public static EmployeeDto getEmployeeDto(EmployeeMasterEntity employeeEntity) {
		EmployeeDto dto = new EmployeeDto();
		dto.setEmployeeId(employeeEntity.getEmployee_id());
		dto.setEmployeeName(employeeEntity.getEmployee_name());
		dto.setDepartment(employeeEntity.getDepartment());
		dto.setDesignation(employeeEntity.getDesignation());
		dto.setGender(employeeEntity.getGender());
		return dto;
		
	}
	
	public static EmployeeMasterEntity getEmployeeEntity(EmployeeDto empDto) {
		EmployeeMasterEntity employee = new EmployeeMasterEntity();
		employee.setEmployee_id(empDto.getEmployeeId());
		employee.setEmployee_name(empDto.getEmployeeName());
		employee.setPassword(empDto.getPassword());
		employee.setDepartment(empDto.getDepartment());
		employee.setDesignation(empDto.getDesignation());
		employee.setGender(empDto.getGender());
		return employee;
	}
}
