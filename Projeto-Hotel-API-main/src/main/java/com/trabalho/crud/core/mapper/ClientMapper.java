package com.trabalho.crud.core.mapper;

import org.mapstruct.Mapper;
import com.trabalho.crud.core.dto.ClientDto;
import com.trabalho.crud.core.entity.Client;

@Mapper(componentModel = "spring")  

public interface ClientMapper {
    
    Client toEntity(ClientDto dto);

    ClientDto toDto(Client entity);
}
