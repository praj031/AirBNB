package com.project.AirBNB.AirBNB.repository;

import com.project.AirBNB.AirBNB.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
