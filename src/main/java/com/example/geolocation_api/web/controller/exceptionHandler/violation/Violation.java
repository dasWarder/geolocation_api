package com.example.geolocation_api.web.controller.exceptionHandler.violation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Violation {

    private String fieldName;
    
    private String message;
}
