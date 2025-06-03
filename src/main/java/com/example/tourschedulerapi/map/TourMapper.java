package com.example.tourschedulerapi.map;

import com.example.tourschedulerapi.entity.Tour;
import com.example.tourschedulerapi.entity.TourImage;
import com.example.tourschedulerapi.model.TourModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TourMapper {
    @Mapping(target = "images", expression = "java(mapImages(tour))")
    TourModel toTourModel(Tour tour);

    default List<String> mapImages(Tour tour) {
        if (tour.getImages() == null) return List.of();
        return tour.getImages()
                .stream()
                .map(TourImage::getUrl)
                .toList();
    }
}
