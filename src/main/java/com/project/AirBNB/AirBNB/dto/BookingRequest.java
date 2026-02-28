package com.project.AirBNB.AirBNB.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;

@JsonPropertyOrder({
        "hotelId",
        "roomId",
        "checkInDate",
        "checkInDate",
        "checkOutDate",
        "roomsCount"
})
@Data
public class BookingRequest {
    private Long hotelId;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer roomsCount;
}
