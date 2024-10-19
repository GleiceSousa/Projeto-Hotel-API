package com.trabalho.crud.core.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.Employee;

@ActiveProfiles("test")
@Repository
public class EmployeeRepositoryMemo implements EmployeeRepository {

  private final List<Employee> employees = new ArrayList<Employee>();

  @Override
  public List<Employee> findAll() {
    return employees;
  }

  @Override
  public Optional<Employee> findById(Long id) {
    return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst();
  }

  @Override
  public Employee save(Employee employee) {
    var id = employees.size() + 1;
    employee.setId((long) id);
    employees.add(employee);
    return employee;
  }

  @Override
  public void deleteById(Long id) {
    employees.removeIf(employee-> employee.getId() == id);
  }
}
