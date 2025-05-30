package com.example.tourschedulerapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String message;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @Column(name = "from_airport")
    private Airport fromAirport;

    @Column(name = "destination_city")
    private String destinationCity;

    @Column(name = "passenger_count")
    private Integer passengerCount;

    @Column(name = "return_trip")
    private Boolean returnTrip;
}
