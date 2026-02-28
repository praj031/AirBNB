package com.project.AirBNB.AirBNB.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.project.AirBNB.AirBNB.entity.User;
import com.project.AirBNB.AirBNB.entity.enums.Gender;
import lombok.Data;

@JsonPropertyOrder({
        "id",
        "user",
        "name",
        "gender",
        "age"
})

@Data
public class GuestDto {
    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;
}
