package com.trabalho.crud.outbound.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.crud.core.entity.Employee;
import com.trabalho.crud.core.repository.EmployeeRepository;

@Profile("!test")
public interface JpaEmployeeRepository  extends EmployeeRepository, JpaRepository<Employee, Long> {
}
