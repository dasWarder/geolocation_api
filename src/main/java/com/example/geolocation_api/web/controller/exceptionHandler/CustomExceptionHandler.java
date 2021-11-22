package com.example.geolocation_api.web.controller.exceptionHandler;

import com.example.geolocation_api.dao.model.Place;
import com.example.geolocation_api.service.exception.ParamNotValidException;
import com.example.geolocation_api.service.exception.PlaceNotFoundException;
import com.example.geolocation_api.web.controller.exceptionHandler.exception.ExceptionResponse;
import com.example.geolocation_api.web.controller.exceptionHandler.violation.Violation;
import com.example.geolocation_api.web.controller.exceptionHandler.violation.ViolationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@RestController
@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(
      value = {
        PlaceNotFoundException.class,
        ParamNotValidException.class,
        MissingServletRequestParameterException.class,
        NullPointerException.class,
        MethodArgumentTypeMismatchException.class,
        HttpClientErrorException.class
      })
  public ResponseEntity<ExceptionResponse> validationException(Exception e) {

    String type = e.getClass().getSimpleName();
    String message = e.getMessage();

    if (e.getCause() != null) {
      type = e.getCause().getClass().getSimpleName();
      message = e.getCause().getMessage();
    }

    ExceptionResponse response = ExceptionResponse.builder().type(type).message(message).build();

    return ResponseEntity.badRequest().body(response);
  }

  @ExceptionHandler(value = {ConstraintViolationException.class})
  public ResponseEntity<ViolationResponse> onConstraintValidationException(
      ConstraintViolationException exception) {

    ViolationResponse response = new ViolationResponse();

    Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();

    constraintViolations.forEach(
        violation -> {
          String fieldName = violation.getPropertyPath().toString();
          String message = violation.getMessage();

          Violation singleViolation =
              Violation.builder().fieldName(fieldName).message(message).build();
          response.getViolations().add(singleViolation);
        });

    return ResponseEntity.badRequest().body(response);
  }

  @ExceptionHandler(value = {MethodArgumentNotValidException.class})
  public ResponseEntity<ViolationResponse> onMethodArgumentException(
      MethodArgumentNotValidException exception) {

    ViolationResponse response = new ViolationResponse();
    List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

    fieldErrors.forEach(
        error -> {
          String fieldName = error.getField();
          String message = error.getDefaultMessage();

          Violation violation = Violation.builder().fieldName(fieldName).message(message).build();
          response.getViolations().add(violation);
        });

    return ResponseEntity.badRequest().body(response);
  }
}
