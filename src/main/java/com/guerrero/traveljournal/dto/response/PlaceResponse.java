package com.guerrero.traveljournal.dto.response;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public record PlaceResponse(
        Long id,
        String title,
        String location,
        String googleMapsUrl,
        LocalDate startDate,
        LocalDate endDate,
        String description,
        String imageUrl,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
}