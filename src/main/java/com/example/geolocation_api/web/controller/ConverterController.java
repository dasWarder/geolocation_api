package com.example.geolocation_api.web.controller;


import com.example.geolocation_api.dao.model.Place;
import com.example.geolocation_api.service.PlaceConvertingService;
import com.example.geolocation_api.service.exception.ParamNotValidException;
import com.example.geolocation_api.service.exception.PlaceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/geolocation")
public class ConverterController {

    private final PlaceConvertingService placeConvertingService;

    @GetMapping
    public ResponseEntity<List<Place>> getPlaceByLocation(@RequestParam("lat") Double lat,
                                                    @RequestParam("lng") Double lng) throws ParamNotValidException {
        List<Place> response = placeConvertingService.findPlaceByLatAndLngFromDbOrAddIt(lat, lng);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Place>> getPlaceByName(@PathVariable("name") String placeName)
                                                                    throws PlaceNotFoundException, ParamNotValidException {

        List<Place> placeByName = placeConvertingService.findPlaceByName(placeName);

        return ResponseEntity.ok(placeByName);
    }

}
