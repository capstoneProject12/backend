package com.luma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luma.entity.EmployeeCardEntity;

public interface EmployeeCardEntityRepo extends JpaRepository<EmployeeCardEntity, Long> {

}
