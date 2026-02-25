package com.project.AirBNB.AirBNB.service.impl;

import com.project.AirBNB.AirBNB.dto.HotelDto;
import com.project.AirBNB.AirBNB.entity.Hotel;
import com.project.AirBNB.AirBNB.entity.Room;
import com.project.AirBNB.AirBNB.exception.ResourceNotFoundException;
import com.project.AirBNB.AirBNB.repository.HotelRepository;
import com.project.AirBNB.AirBNB.service.HotelService;
import com.project.AirBNB.AirBNB.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    private final InventoryService inventoryService;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("Inside the create hotelData service impl layer");
        Hotel hotel = modelMapper.map(hotelDto, Hotel.class);  //First we map dto to entity
        hotel.setActive(false);
        hotel = hotelRepository.save(hotel); //Save it
        log.info("Created a new hotel with ID: {}", hotel.getId());
        return modelMapper.map(hotel, HotelDto.class); //Map back entity to Dto
    }

    @Override
    public List<HotelDto> getAllHotel() {
        log.info("Inside the get all hotel as a list in service layer");
        return hotelRepository.findAll()
                .stream()
                .map(hotel -> modelMapper.map(hotel, HotelDto.class))
                .toList();
    }

    @Override
    public HotelDto getHotelById(Long hotelId) {
        log.info("Getting the hotel with ID: {}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+hotelId));
        return modelMapper.map(hotel, HotelDto.class);
    }


    public HotelDto updateHotelDetailsById(Long id, HotelDto hotelDto) {
        log.info("Updating the hotel with ID: {}", id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+id));
        modelMapper.map(hotelDto, hotel);
        hotel.setId(id);
        hotel = hotelRepository.save(hotel);
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    @Transactional
    public void deleteHotelById(Long id) {
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+id));

        hotelRepository.deleteById(id);
        for(Room room: hotel.getRooms()) {
            inventoryService.deleteFutureInventories(room);
        }
    }

    @Override
    @Transactional
    public void activateHotel(Long hotelId) {
        log.info("Activating the hotel with ID: {}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+hotelId));

        hotel.setActive(true);

        // assuming only do it once
        for(Room room: hotel.getRooms()) {
            inventoryService.initializeRoomForAYear(room);
        }
    }



}
