package com.project.AirBNB.AirBNB.repository;


import com.project.AirBNB.AirBNB.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
