package com.trabalho.crud.outbound.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import com.trabalho.crud.core.entity.Room;
import com.trabalho.crud.core.repository.RoomRepository;

@Profile("!test")
public interface JpaRoomRepository extends RoomRepository, JpaRepository<Room, Long> {
   
}
