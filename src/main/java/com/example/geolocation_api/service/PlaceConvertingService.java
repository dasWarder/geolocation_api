package com.example.geolocation_api.service;

import com.example.geolocation_api.dao.model.Place;

public interface PlaceConvertingService {

    Place findPlaceByLatAndLngFromDbOrAddIt(Float lat, Float lng);

    Place findPlaceByNameFromDbOrAddIt(String name);
}
