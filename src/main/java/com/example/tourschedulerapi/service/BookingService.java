package com.example.tourschedulerapi.service;


import com.example.tourschedulerapi.entity.Booking;
import com.example.tourschedulerapi.entity.Tour;
import com.example.tourschedulerapi.model.BookingRequest;
import com.example.tourschedulerapi.repository.BookingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingService {
    private final BookingRepository bookingRepository;
    private final TourService tourService;
    private final EmailService notification;

    @Transactional
    public String bookTour(BookingRequest request) {
        Tour tour = tourService.findById(request.tourId());

        Booking booking = new Booking();
        booking.setTour(tour);
        booking.setDate(request.date());
        booking.setEmail(request.email());
        booking.setMessage(request.message());
        bookingRepository.save(booking);
        String msg = String.format("order accepted from user with email %s data %s tour %s with message - %s",
                request.email(),request.date(), tour.getName(),request.message());
        notification.sendNotification(msg);
        return msg;

    }
}
