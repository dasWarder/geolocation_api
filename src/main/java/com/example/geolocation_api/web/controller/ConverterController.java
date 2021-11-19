package com.example.geolocation_api.web.controller;


import com.example.geolocation_api.dao.dto.response.ResponseWithLocation;
import com.example.geolocation_api.dao.dto.response.ResponseWithName;
import com.example.geolocation_api.mapping.PlaceMapper;
import com.example.geolocation_api.service.PlaceConvertingService;
import com.example.geolocation_api.service.exception.ParamNotValidException;
import com.example.geolocation_api.service.exception.PlaceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/geolocation")
@CrossOrigin(origins = "http://localhost:3000")
public class ConverterController {

    private final PlaceMapper mapper;

    private final PlaceConvertingService placeConvertingService;

    @GetMapping
    public ResponseEntity<List<ResponseWithName>> getPlaceByLocation(@RequestParam("lat") @NotBlank Double lat,
                                                                     @RequestParam("lng") @NotBlank Double lng) throws ParamNotValidException {
        List<ResponseWithName> responseDto = placeConvertingService.findPlaceByLatAndLngFromDbOrAddIt(lat, lng)
                                                                                                            .stream()
                                                                                                            .map(mapper::placeToResponseWithName)
                                                                                                            .collect(Collectors.toList());
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<ResponseWithLocation>> getPlaceByName(@PathVariable("name") @NotBlank String placeName)
                                                                    throws PlaceNotFoundException, ParamNotValidException {
        List<ResponseWithLocation> responseDto = placeConvertingService.findPlaceByName(placeName)
                                                                                .stream()
                                                                                .map(mapper::placeToResponseWithLocation)
                                                                                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDto);
    }

}
