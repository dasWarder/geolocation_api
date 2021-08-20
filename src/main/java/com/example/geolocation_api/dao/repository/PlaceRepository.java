package com.example.geolocation_api.dao.repository;

import com.example.geolocation_api.dao.model.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlaceRepository extends CrudRepository<Place, String> {

    Optional<Place> getPlaceByLatAndLng(Float lat, Float lng);

    Optional<Place> getPlaceByName(String name);
}
