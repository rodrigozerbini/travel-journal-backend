package com.guerrero.traveljournal.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record PlaceRequest(
        @NotBlank(message = "Title is required")
        @Size(max = 150, message = "Title must not exceed 150 characters")
        String title,

        @NotBlank(message = "Location is required")
        @Size(max = 100, message = "Location must not exceed 100 characters")
        String location,

        @Size(max = 500, message = "Google Maps URL must not exceed 500 characters")
        String googleMapsUrl,

        @NotNull(message = "Start date is required")
        LocalDate startDate,

        @NotNull(message = "End date is required")
        LocalDate endDate,

        String description,

        @Size(max = 500, message = "Image URL must not exceed 500 characters")
        String imageUrl
) {}