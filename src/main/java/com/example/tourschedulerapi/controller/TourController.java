package com.example.tourschedulerapi.controller;

import com.example.tourschedulerapi.model.TourModel;
import com.example.tourschedulerapi.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tours")
public class TourController {

    private final TourService tourService;

    @GetMapping
    public List<TourModel> getAllTours() {
        return tourService.getTour();
    }
}

