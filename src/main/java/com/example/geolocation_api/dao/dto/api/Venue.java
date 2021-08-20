package com.example.geolocation_api.dao.dto.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class Venue {

    @JsonProperty
    private String id;

    @JsonProperty
    private String name;

    @JsonProperty
    private Location location;

    @JsonProperty
    private List<Category> categories;
}
