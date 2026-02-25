package com.project.AirBNB.AirBNB.service;

import com.project.AirBNB.AirBNB.entity.Room;


public interface InventoryService{

    void deleteFutureInventories(Room room);

    void initializeRoomForAYear(Room room);

}
