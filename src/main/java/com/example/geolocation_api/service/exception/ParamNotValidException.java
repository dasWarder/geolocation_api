package com.example.geolocation_api.service.exception;

public class ParamNotValidException extends Throwable {

    public ParamNotValidException() {
    }

    public ParamNotValidException(String message) {
        super(message);
    }

    public ParamNotValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
