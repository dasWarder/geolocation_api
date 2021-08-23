package com.example.geolocation_api.service;

import com.example.geolocation_api.dao.model.Place;
import com.example.geolocation_api.service.exception.ParamNotValidException;

import java.util.List;

public interface PlaceService {

    List<Place> saveAllPlaces(List<Place> places) throws ParamNotValidException;

    List<Place> getPlaceByLocation(Double lat, Double lng) throws ParamNotValidException;

    List<Place> getPlacesByName(String name) throws ParamNotValidException;
}
