package com.example.AirlineReservationDemo.Advice;


import com.example.AirlineReservationDemo.CustomException.EmptyInputException;
import com.example.AirlineReservationDemo.CustomException.ValidationException;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException)
    {
        return new ResponseEntity<String>("InputField is Empty", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (NoSuchElementException.class)

    public ResponseEntity<String> handleNoElement(NoSuchElementException elementException)
    {
        return new ResponseEntity<String>("No Such Id...Please Check ", HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler (HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> handleRequestMethod(HttpRequestMethodNotSupportedException exception)
    {
        return new ResponseEntity<Object>("Invalid Request..Please Check", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException exception)
    {
        return new ResponseEntity<Object>("Invalid Request..Please Check", HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)

    public ResponseEntity<Object> handleGlobalException(Exception exception)
    {
        return new ResponseEntity<Object>("Error Occurred while processing the request...please verify", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(ValidationException exception)
    {
        return new ResponseEntity<Object>("Error in Validation...Please Check the inputField", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ArrayStoreException.class)
    public ResponseEntity<Object> handleArrayStoreException(ArrayStoreException exception)
    {
        return new ResponseEntity<Object>("Sorry Tickets Not Available", HttpStatus.NOT_ACCEPTABLE);
    }


}
