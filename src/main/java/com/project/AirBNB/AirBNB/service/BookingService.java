package com.project.AirBNB.AirBNB.service;

import com.project.AirBNB.AirBNB.dto.BookingDto;
import com.project.AirBNB.AirBNB.dto.BookingRequest;
import com.project.AirBNB.AirBNB.dto.GuestDto;

import java.util.List;

public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
