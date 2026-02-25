package com.project.AirBNB.AirBNB.repository;

import com.project.AirBNB.AirBNB.entity.Inventory;
import com.project.AirBNB.AirBNB.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    void deleteByDateAfterAndRoom(LocalDate today, Room room);

}
