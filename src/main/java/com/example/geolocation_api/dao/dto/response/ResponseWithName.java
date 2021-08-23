package com.example.geolocation_api.dao.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWithName {

    private String name;
    private String address;
    private Double lat;
    private Double lng;
}
