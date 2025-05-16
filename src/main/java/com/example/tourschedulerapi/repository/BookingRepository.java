package com.example.tourschedulerapi.repository;

import com.example.tourschedulerapi.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
