package com.example.geolocation_api.service;

import com.example.geolocation_api.dao.model.Place;

public interface PlaceService {

    Place savePlace(Place place);

    Place getPlaceByLocation(Float lat, Float lng);

    Place getPlaceById(String id);

    Place deletePlaceById(String id);
}
