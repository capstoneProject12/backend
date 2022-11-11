package com.luma.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luma.entity.EmployeeMasterEntity;
import com.luma.entity.LoanCardEntity;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeMasterEntity, String> {

	Optional<EmployeeMasterEntity> findById(String employeeId);
}
