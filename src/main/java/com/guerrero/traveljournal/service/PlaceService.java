package com.guerrero.traveljournal.service;

import com.guerrero.traveljournal.dto.request.PlaceRequest;
import com.guerrero.traveljournal.dto.response.PlaceResponse;
import com.guerrero.traveljournal.entity.Place;
import com.guerrero.traveljournal.mapper.PlaceMapper;
import com.guerrero.traveljournal.repository.PlaceRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Business logic handler for managing places.
 * Architectural Decision:
 * We intentionally define this as a concrete class rather than creating a 1 to 1 interface
 * and implementation.
 * Modern Spring Boot allows working with concrete classes when there is only one necessary implementation.
 */
@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final PlaceMapper placeMapper;

    @Transactional
    public PlaceResponse createPlace(PlaceRequest request) {
        Place place = placeMapper.toEntity(request);
        Place savedPlace = placeRepository.save(place);
        return placeMapper.toResponse(savedPlace);
    }

    @Transactional(readOnly = true)
    public List<PlaceResponse> getAllPlaces() {
        return placeRepository.findAll()
                .stream()
                .map(placeMapper::toResponse)
                .toList();
    }
}