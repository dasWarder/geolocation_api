package com.example.geolocation_api.mapping;

import com.example.geolocation_api.dao.dto.response.ResponseWithLocation;
import com.example.geolocation_api.dao.dto.response.ResponseWithName;
import com.example.geolocation_api.dao.model.Place;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PlaceMapper {

    @Mapping(target = "name", source = "name")
    ResponseWithName placeToResponseWithName(Place place);

    ResponseWithLocation placeToResponseWithLocation(Place place);
}
