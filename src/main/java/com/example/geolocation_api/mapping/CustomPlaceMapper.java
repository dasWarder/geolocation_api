package com.example.geolocation_api.mapping;

import com.example.geolocation_api.dao.dto.api.ApiRequest;
import com.example.geolocation_api.dao.dto.api.Location;
import com.example.geolocation_api.dao.dto.api.Venue;
import com.example.geolocation_api.dao.dto.api.VenueLocation;
import com.example.geolocation_api.dao.model.Place;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;


@Mapper
@NoArgsConstructor
public abstract class CustomPlaceMapper {


    public List<Place> venueLocationToListOfPlaces(VenueLocation location) {

        ApiRequest response = location.getResponse();
        List<Venue> venues = response.getVenues();

        List<Place> places = new ArrayList<>();

        venues.forEach(venue -> {

            Location venueLocation = venue.getLocation();
            String city = venueLocation.getCity();
            String state = venueLocation.getState();
            String country = venueLocation.getCountry();

            String address = String.format("%s%s%s",
                                                    city == null? "" : city + " ",
                                                    state == null? "" : state + " ",
                                                    country == null? "" : country);


            Place place = Place.builder()
                                    .id(venue.getId())
                                    .name(venue.getName())
                                    .lat(venueLocation.getLat())
                                    .lng(venueLocation.getLng())
                                    .address(address)
                                    .build();

            places.add(place);
        });

        return places;
    }
}
