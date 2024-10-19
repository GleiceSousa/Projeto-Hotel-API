package com.trabalho.crud.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trabalho.crud.core.dto.EmployeeDto;
import com.trabalho.crud.core.entity.BusinessException;
import com.trabalho.crud.core.mapper.EmployeeMapper;
import com.trabalho.crud.core.repository. EmployeeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmployeeService {

  private final EmployeeRepository repository;

  private final EmployeeMapper mapper;

  public List<EmployeeDto> findAll() {
    return repository.findAll().stream().map(employee -> mapper.toDto(employee)).toList();
  }

  public EmployeeDto findById(Long id) {
    return repository.findById(id).map(employee -> mapper.toDto(employee))
        .orElseThrow(() -> BusinessException.notFoundException("Funcionário não encontrado"));
  }

  public EmployeeDto save(EmployeeDto employeeDto) {
    var employee = mapper.toEntity(employeeDto);
    return mapper.toDto(repository.save(employee));
  }

  public EmployeeDto update(Long id, EmployeeDto employeeDto) {
    var existingEmployee = this.findById(id);
    employeeDto.setId(existingEmployee.getId());
    var employee = mapper.toEntity(employeeDto);
    return mapper.toDto(repository.save(employee));
  }

  public void deleteById(Long id) {
    this.findById(id);
    repository.deleteById(id);
  }

}
