package com.example.tourschedulerapi.repository;


import com.example.tourschedulerapi.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {
}
