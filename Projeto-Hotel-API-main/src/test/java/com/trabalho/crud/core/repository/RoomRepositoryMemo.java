package com.trabalho.crud.core.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.Room;

@ActiveProfiles("test")
@Repository
public class RoomRepositoryMemo implements RoomRepository {

  private final List<Room> rooms = new ArrayList<Room>();

  @Override
  public List<Room> findAll() {
    return rooms;
  }

  @Override
  public Optional<Room> findById(Long id) {
    return rooms.stream().filter(room -> room.getId().equals(id)).findFirst();
  }

  @Override
  public Room save(Room room) {
    var id = rooms.size() + 1;
    room.setId((long) id);
    rooms.add(room);
    return room;
  }

  @Override
  public void deleteById(Long id) {
    rooms.removeIf(room -> room.getId() == id);
  }
}
