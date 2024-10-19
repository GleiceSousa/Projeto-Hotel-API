package com.trabalho.crud.core.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.trabalho.crud.core.dto.RoomDto;
import com.trabalho.crud.core.entity.BusinessException;
import com.trabalho.crud.core.mapper.RoomMapper;
import com.trabalho.crud.core.repository.RoomRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RoomService {

    private final RoomRepository repository;

    private final RoomMapper mapper;

    public List<RoomDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public RoomDto findById(Long id) {
        return repository.findById(id).map(mapper::toDto)
                .orElseThrow(() -> BusinessException.notFoundException("Quarto não encontrado"));
    }

    public RoomDto save(RoomDto roomDto) {
        var room = mapper.toEntity(roomDto);
        return mapper.toDto(repository.save(room));
    }

    public RoomDto update(Long id, RoomDto roomDto) {
        var existingRoom = this.findById(id);
        roomDto.setId(existingRoom.getId());
        var room = mapper.toEntity(roomDto);
        return mapper.toDto(repository.save(room));
    }

    public void deleteById(Long id) {
        this.findById(id);
        repository.deleteById(id);
    }
}
