package com.project.AirBNB.AirBNB.service;

import com.project.AirBNB.AirBNB.dto.HotelDto;
import com.project.AirBNB.AirBNB.dto.HotelInfoDto;

import java.util.List;

public interface HotelService {

    //This is where basically we want to put the service methods

    HotelDto createNewHotel(HotelDto hotelDto);

    List<HotelDto> getAllHotel();

    HotelDto getHotelById(Long hotelId);

    HotelDto updateHotelDetailsById(Long hotelId,HotelDto hotelDto);

    void deleteHotelById(Long id);

    void activateHotel(Long hotelId);

    HotelInfoDto getHotelInfoById(Long hotelId);


}
