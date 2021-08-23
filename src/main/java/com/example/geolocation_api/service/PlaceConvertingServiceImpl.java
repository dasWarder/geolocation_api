package com.example.geolocation_api.service;

import com.example.geolocation_api.dao.dto.api.VenueLocation;
import com.example.geolocation_api.dao.model.Place;
import com.example.geolocation_api.mapping.CustomPlaceMapper;
import com.example.geolocation_api.service.exception.ParamNotValidException;
import com.example.geolocation_api.service.exception.PlaceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaceConvertingServiceImpl implements PlaceConvertingService {

    @Value("${api.foursquare.id}")
    private String clientId;

    @Value("${api.foursquare.secret}")
    private String clientSecret;

    private final CustomPlaceMapper mapper;

    private final RestTemplate restTemplate;

    private final PlaceService placeService;

    private static final String BASE_URL =
            "https://api.foursquare.com/v2/venues/search?ll=%s,%s&client_id=%s&client_secret=%s&v=%s";

    private static final String VERSION = Arrays.stream(LocalDate.now()
                                                                        .toString()
                                                                        .split("-"))
                                                                        .collect(Collectors.joining(""));

    @Override
    public List<Place> findPlaceByLatAndLngFromDbOrAddIt(Double lat, Double lng) throws ParamNotValidException {

            List<Place> placesByLocation = placeService.getPlaceByLocation(lat, lng);

            if (placesByLocation.isEmpty()) {

                VenueLocation responsePlace = restTemplate.getForObject(
                        String.format(BASE_URL, lat.toString(), lng.toString(), clientId, clientSecret, VERSION), VenueLocation.class);

                List<Place> places = mapper.venueLocationToListOfPlaces(responsePlace)
                                                                                    .stream()
                                                                                    .limit(5)
                                                                                    .collect(Collectors.toList());
                List<Place> responsePlaces = placeService.saveAllPlaces(places);


                return responsePlaces;
            }

            return placesByLocation;
    }

    @Override
    public List<Place> findPlaceByName(String name) throws ParamNotValidException, PlaceNotFoundException {

        List<Place> placesByName = placeService.getPlacesByName(name);

        if(placesByName.isEmpty()) {
            throw new PlaceNotFoundException(String.format(
                    "The place with name=%s not found", name));
        }

        return placesByName;
    }
}
