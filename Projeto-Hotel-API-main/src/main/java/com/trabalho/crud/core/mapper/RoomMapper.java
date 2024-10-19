package com.trabalho.crud.core.mapper;

import org.mapstruct.Mapper;
import com.trabalho.crud.core.dto.RoomDto;
import com.trabalho.crud.core.entity.Room;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    Room toEntity(RoomDto dto);

    RoomDto toDto(Room entity);
}
