package com.project.AirBNB.AirBNB.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.project.AirBNB.AirBNB.entity.HotelContactInfo;
import lombok.Data;


@JsonPropertyOrder({
        "id",
        "name",
        "city",
        "photos",
        "amenities",
        "contactInfo",
        "active"
})

@Data
public class HotelDto {
    private Long id;
    private String name;
    private String city;
    private String[] photos;
    private String[] amenities;
    private HotelContactInfo contactInfo;
    private Boolean active;
}
