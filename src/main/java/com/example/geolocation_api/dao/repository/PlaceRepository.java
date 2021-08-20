package com.example.geolocation_api.dao.repository;

import com.example.geolocation_api.dao.model.Place;
import org.springframework.data.repository.CrudRepository;

public interface PlaceRepository extends CrudRepository<Place, String> {

}
