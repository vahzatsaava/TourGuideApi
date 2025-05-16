package com.example.tourschedulerapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TourModel {
    private Long id;
    private String name;
    private String description;
    private String image;
}
