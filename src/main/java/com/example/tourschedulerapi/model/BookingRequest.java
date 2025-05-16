package com.example.tourschedulerapi.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record BookingRequest(
        @NotNull Long tourId,
        @NotBlank @Email String email,
        @NotBlank String message,
        @NotNull LocalDate date
) {
}
