package com.example.geolocation_api.service;

import com.example.geolocation_api.dao.model.Place;
import com.example.geolocation_api.dao.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    @Override
    public Place savePlace(Place place) {
        return null;
    }

    @Override
    public Place getPlaceByLocation(Float lat, Float lng) {
        return null;
    }

    @Override
    public Place getPlaceById(String id) {
        return null;
    }

    @Override
    public Place deletePlaceById(String id) {
        return null;
    }
}
