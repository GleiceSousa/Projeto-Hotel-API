package com.trabalho.crud.core.repository;

import java.util.List;
import java.util.Optional;

import com.trabalho.crud.core.entity.Employee;

public interface EmployeeRepository {

  List<Employee> findAll();

  Optional<Employee> findById(Long id);

  Employee save(Employee employee);

  void deleteById(Long id);
}
