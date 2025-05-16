package com.example.tourschedulerapi.service;

import com.example.tourschedulerapi.entity.Tour;
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

    public List<TourModel> getTour() {
        List<Tour> tours = tourRepository.findAll();
        return tours.stream()
                .map(res ->
                {
                    TourModel model = new TourModel();
                    model.setDescription(res.getDescription());
                    model.setId(res.getId());
                    model.setName(res.getName());
                    model.setImage(res.getImage());
                    return model;
                })
                .toList();
    }
    public Tour findById(Long id){
        return tourRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("entity not found"));
    }
}
