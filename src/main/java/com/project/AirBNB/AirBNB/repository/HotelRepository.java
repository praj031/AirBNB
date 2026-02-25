package com.project.AirBNB.AirBNB.repository;

import com.project.AirBNB.AirBNB.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
