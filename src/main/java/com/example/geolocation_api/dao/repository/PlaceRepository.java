package com.example.geolocation_api.dao.repository;

import com.example.geolocation_api.dao.model.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaceRepository extends CrudRepository<Place, String> {

    List<Place> getPlacesByLatAndLng(Double lat, Double lng);

    List<Place> getPlacesByName(String name);

}
