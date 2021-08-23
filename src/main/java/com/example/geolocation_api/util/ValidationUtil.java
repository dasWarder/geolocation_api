package com.example.geolocation_api.util;

import com.example.geolocation_api.service.exception.ParamNotValidException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ValidationUtil {

    public static <T> void validateParams(T ... params) throws ParamNotValidException {

        List<Boolean> notValidParamsList = Arrays.stream(params)
                .map(param -> Objects.nonNull(param))
                .filter(param -> param == false)
                .collect(Collectors.toList());

        if(!notValidParamsList.isEmpty()) {
            throw new ParamNotValidException("One or several params are not valid");
        }
    }
}
