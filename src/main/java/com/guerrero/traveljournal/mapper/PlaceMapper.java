package com.guerrero.traveljournal.mapper;

import com.guerrero.traveljournal.dto.request.PlaceRequest;
import com.guerrero.traveljournal.dto.response.PlaceResponse;
import com.guerrero.traveljournal.entity.Place;
import com.guerrero.traveljournal.mapper.config.CentralMapperConfig;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface PlaceMapper {

    Place toEntity(PlaceRequest request);

    PlaceResponse toResponse(Place place);
}