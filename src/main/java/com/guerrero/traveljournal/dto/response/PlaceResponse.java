package com.guerrero.traveljournal.dto.response;

import java.time.LocalDate;

public record PlaceResponse(
        Long id,
        String title,
        String location,
        String googleMapsUrl,
        LocalDate startDate,
        LocalDate endDate,
        String description,
        String imageUrl
) {
}