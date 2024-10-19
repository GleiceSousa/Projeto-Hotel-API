package com.trabalho.crud.core.mapper;

import org.mapstruct.Mapper;

import com.trabalho.crud.core.dto.EmployeeDto;
import com.trabalho.crud.core.entity.Employee;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {

  Employee toEntity(EmployeeDto dto);

  EmployeeDto toDto(Employee entity);
  
}
