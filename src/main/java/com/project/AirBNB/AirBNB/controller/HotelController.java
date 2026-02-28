package com.project.AirBNB.AirBNB.controller;

import com.project.AirBNB.AirBNB.advice.ApiResponse;
import com.project.AirBNB.AirBNB.dto.HotelDto;
import com.project.AirBNB.AirBNB.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/hotels")
@RequiredArgsConstructor
@Slf4j
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<ApiResponse<HotelDto>> createNewHotel(@RequestBody HotelDto hotelDto) {
        log.info("Attempting to create a new hotel with name: {}", hotelDto.getName());
        HotelDto hotel = hotelService.createNewHotel(hotelDto);
        ApiResponse<HotelDto> response = new ApiResponse<>(hotel);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<HotelDto>>> listOfAllHotels() {
        log.info("Inside the get all hotels controller");
        List<HotelDto> hotels = hotelService.getAllHotel();
        return ResponseEntity.ok(new ApiResponse<>(hotels));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<ApiResponse<HotelDto>> getHotelById(@PathVariable Long hotelId){
        log.info("Inside the get hotel by id controller");
        HotelDto hotelDto = hotelService.getHotelById(hotelId);
        ApiResponse<HotelDto> response = new ApiResponse<>(hotelDto);
        return new  ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<ApiResponse<HotelDto>> updateHotelDetailsById(
            @PathVariable Long hotelId,
            @RequestBody HotelDto hotelDto){
        log.info("Inside the update hotel by id controller");
        HotelDto hotel = hotelService.updateHotelDetailsById(hotelId,hotelDto);
        ApiResponse<HotelDto> response = new ApiResponse<>(hotel);
        return new  ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteHotelById(@PathVariable Long hotelId) {
        log.info("Inside the delete hotel by id controller");
        hotelService.deleteHotelById(hotelId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{hotelId}/activate")
    public ResponseEntity<Void> activateHotel(@PathVariable Long hotelId) {
        log.info("Inside the activating hotel by id controller");
        hotelService.activateHotel(hotelId);
        return ResponseEntity.noContent().build();
    }


}
