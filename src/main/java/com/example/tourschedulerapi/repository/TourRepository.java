package com.example.tourschedulerapi.repository;


import com.example.tourschedulerapi.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {
    @Query("SELECT t FROM Tour t LEFT JOIN FETCH t.images")
    List<Tour> findAllWithImages();

}
