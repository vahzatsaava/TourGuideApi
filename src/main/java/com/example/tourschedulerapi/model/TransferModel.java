package com.example.tourschedulerapi.model;

import com.example.tourschedulerapi.entity.Airport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransferModel {

    private Long id;

    private String email;

    private String message;

    private LocalDateTime date;

    private Airport fromAirport;

    private String destinationCity;

    private Integer passengerCount;

    private Boolean returnTrip;
}
