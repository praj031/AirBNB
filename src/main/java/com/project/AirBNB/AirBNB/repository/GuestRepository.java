package com.project.AirBNB.AirBNB.repository;

import com.project.AirBNB.AirBNB.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}