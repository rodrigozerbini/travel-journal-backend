package com.guerrero.traveljournal.service;

import com.guerrero.traveljournal.dto.request.PlaceRequest;
import com.guerrero.traveljournal.dto.response.PlaceResponse;
import com.guerrero.traveljournal.entity.Place;
import com.guerrero.traveljournal.mapper.PlaceMapper;
import com.guerrero.traveljournal.repository.PlaceRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlaceServiceTest {

    @Mock
    private PlaceRepository placeRepository;

    @Mock
    private PlaceMapper placeMapper;

    @InjectMocks
    private PlaceService placeService;

    @Test
    @DisplayName("Should create place successfully when given valid request")
    void createPlace_ShouldReturnPlaceResponse_WhenRequestIsValid() {
        PlaceRequest request = new PlaceRequest(
                "Brazil",
                "Sao Paulo",
                "https://maps.google.com/...",
                LocalDate.of(2026, 10, 7),
                LocalDate.of(2026, 10, 24),
                "Trip to Brazil",
                "https://images.com/brazil.jpg"
        );

        Place place = new Place();
        PlaceResponse expectedResponse = new PlaceResponse(
                1L,
                "Brazil",
                "Sao Paulo",
                "https://maps.google.com/...",
                LocalDate.of(2026, 10, 7),
                LocalDate.of(2026, 10, 24),
                "Trip to Brazil",
                "https://images.com/brazil.jpg"
        );

        when(placeMapper.toEntity(request)).thenReturn(place);
        when(placeRepository.save(place)).thenReturn(place);
        when(placeMapper.toResponse(place)).thenReturn(expectedResponse);

        PlaceResponse actualResponse = placeService.createPlace(request);

        assertThat(actualResponse).isNotNull();
        assertThat(actualResponse.id()).isEqualTo(1L);
        assertThat(actualResponse.title()).isEqualTo("Brazil");

        verify(placeMapper).toEntity(request);
        verify(placeRepository).save(place);
        verify(placeMapper).toResponse(place);
    }

    @Test
    @DisplayName("Should return list of places when places exist")
    void getAllPlaces_ShouldReturnList_WhenPlacesExist() {
        Place place = new Place();
        place.setId(1L);

        PlaceResponse response = new PlaceResponse(
                1L,
                "Brazil",
                "Sao Paulo",
                null,
                LocalDate.of(2026, 10, 7),
                LocalDate.of(2026, 10, 24),
                null,
                null
        );

        when(placeRepository.findAll()).thenReturn(List.of(place));
        when(placeMapper.toResponse(place)).thenReturn(response);

        List<PlaceResponse> result = placeService.getAllPlaces();

        assertThat(result).hasSize(1);
        assertThat(result.getFirst().id()).isEqualTo(1L);

        verify(placeRepository).findAll();
        verify(placeMapper).toResponse(place);
    }
}