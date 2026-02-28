package com.project.AirBNB.AirBNB.service;

import com.project.AirBNB.AirBNB.dto.HotelPriceDto;
import com.project.AirBNB.AirBNB.dto.HotelSearchRequest;
import com.project.AirBNB.AirBNB.entity.Room;
import org.springframework.data.domain.Page;


public interface InventoryService{

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceDto> searchHotels(HotelSearchRequest hotelSearchRequest);

}
