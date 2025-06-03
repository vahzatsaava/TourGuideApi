package com.example.tourschedulerapi.service;

import com.example.tourschedulerapi.entity.Tour;
import com.example.tourschedulerapi.map.TourMapper;
import com.example.tourschedulerapi.model.TourModel;
import com.example.tourschedulerapi.repository.TourRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourService {
    private final TourRepository tourRepository;
    private final TourMapper tourMapper;

    public List<TourModel> getTour() {
        List<Tour> tours = tourRepository.findAllWithImages();
        return tours.stream()
                .map(tourMapper::toTourModel)
                .toList();
    }
    public Tour findById(Long id){
        return tourRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("entity not found"));
    }
}
