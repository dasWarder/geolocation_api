package com.example.geolocation_api.service;

import com.example.geolocation_api.dao.model.Place;
import com.example.geolocation_api.dao.repository.PlaceRepository;
import com.example.geolocation_api.service.exception.ParamNotValidException;
import com.example.geolocation_api.service.exception.PlaceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.geolocation_api.util.ValidationUtil.validateParams;


@Slf4j
@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    @Override
    public List<Place> saveAllPlaces(List<Place> places) throws ParamNotValidException {
        validateParams(places);
        log.info("Storing a collection of places");

        List<Place> responseList = (List<Place>) placeRepository.saveAll(places);

        return responseList;
    }

    @Override
    public List<Place> getPlaceByLocation(Double lat, Double lng) throws ParamNotValidException {
        validateParams(lat, lng);
        log.info("Receiving a place by its lat= {} and lng= {}", lat, lng);

        List<Place> placesFromDb = placeRepository.getPlacesByLatAndLng(lat, lng);

        return placesFromDb;
    }

    @Override
    public List<Place> getPlacesByName(String name) throws ParamNotValidException{
        validateParams(name);
        log.info("Receiving a place by its name= {}", name);

        List<Place> placesByName = placeRepository.getPlacesByName(name);

        return placesByName;
    }
}
