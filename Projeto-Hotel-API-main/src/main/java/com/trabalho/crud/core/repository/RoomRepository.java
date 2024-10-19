package com.trabalho.crud.core.repository;

import java.util.List;
import java.util.Optional;


import com.trabalho.crud.core.entity.Room;

public interface RoomRepository {

  List<Room> findAll();

  Optional<Room> findById(Long id);

  Room save(Room client);

  void deleteById(Long id);
}


