package com.project.AirBNB.AirBNB.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;
@JsonPropertyOrder({
        "city",
        "startDate",
        "endDate",
        "roomsCount"
})
@Data
public class HotelSearchRequest {
    private String city;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer roomsCount;

    private Integer page=0;
    private Integer size=10;
}
