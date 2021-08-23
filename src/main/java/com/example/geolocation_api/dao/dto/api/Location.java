package com.example.geolocation_api.dao.dto.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class Location {

    @JsonProperty
    private Double lat;

    @JsonProperty
    private Double lng;

    @JsonProperty
    private String city;

    @JsonProperty
    private String state;

    @JsonProperty
    private String country;
}
