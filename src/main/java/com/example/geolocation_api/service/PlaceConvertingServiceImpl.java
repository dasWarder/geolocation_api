package com.example.geolocation_api.service;

import com.example.geolocation_api.dao.model.Place;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class PlaceConvertingServiceImpl implements PlaceConvertingService {

    private final ObjectMapper mapper;

    private final RestTemplate restTemplate;

    private final PlaceService placeService;

    @Override
    public Place findPlaceByLatAndLngFromDbOrAddIt(Float lat, Float lng) {
        return null;
    }

    @Override
    public Place findPlaceByNameFromDbOrAddIt(String name) {
        return null;
    }
}
