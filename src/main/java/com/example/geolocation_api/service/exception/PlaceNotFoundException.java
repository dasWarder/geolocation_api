package com.example.geolocation_api.service.exception;

public class PlaceNotFoundException extends Throwable {

    public PlaceNotFoundException() {
    }

    public PlaceNotFoundException(String message) {
        super(message);
    }

    public PlaceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
