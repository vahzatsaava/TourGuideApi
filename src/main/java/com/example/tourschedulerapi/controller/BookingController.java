package com.example.tourschedulerapi.controller;

import com.example.tourschedulerapi.model.BookingRequest;
import com.example.tourschedulerapi.service.BookingService;
import com.example.tourschedulerapi.service.TourService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/bookings")
public class BookingController {
    private final BookingService bookingService;
    private final TourService tourService;

    @PostMapping
    public String bookTour(@Valid @RequestBody BookingRequest request) {
        return bookingService.bookTour(request);
    }

}
