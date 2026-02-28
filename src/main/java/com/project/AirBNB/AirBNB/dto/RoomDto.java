package com.project.AirBNB.AirBNB.dto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.math.BigDecimal;
@JsonPropertyOrder({
        "id",
        "type",
        "basePrice",
        "capacity",
        "totalCount",
        "photos",
        "amenities"
})
@Data
public class RoomDto {
    private Long id;
    private String type;
    private BigDecimal basePrice;
    private String[] photos;
    private String[] amenities;
    private Integer totalCount;
    private Integer capacity;
}
