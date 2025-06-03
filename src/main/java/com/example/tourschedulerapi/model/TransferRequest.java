package com.example.tourschedulerapi.model;

import com.example.tourschedulerapi.entity.Airport;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TransferRequest(@NotNull String email,
                              @NotNull String message,
                              @NotNull LocalDateTime date,
                              @NotNull Airport fromAirport,
                              @NotBlank  String destinationCity,
                              @NotNull @Max(9) Integer passengerCount,
                              Boolean returnTrip) {
}
