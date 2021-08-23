package com.example.geolocation_api.service;

import com.example.geolocation_api.dao.model.Place;
import com.example.geolocation_api.service.exception.ParamNotValidException;
import com.example.geolocation_api.service.exception.PlaceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlaceConvertingService {

    List<Place> findPlaceByLatAndLngFromDbOrAddIt(Double lat, Double lng) throws ParamNotValidException;

    List<Place> findPlaceByName(String name) throws PlaceNotFoundException, ParamNotValidException;
}
