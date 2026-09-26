package com.guerrero.traveljournal.controller;

import com.guerrero.traveljournal.dto.request.PlaceRequest;
import com.guerrero.traveljournal.dto.response.PlaceResponse;
import com.guerrero.traveljournal.service.PlaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @PostMapping
    public ResponseEntity<PlaceResponse> createPlace(@Valid @RequestBody PlaceRequest request) {
        PlaceResponse response = placeService.createPlace(request);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PlaceResponse>> getAllPlaces() {
        return ResponseEntity.ok(placeService.getAllPlaces());
    }
}