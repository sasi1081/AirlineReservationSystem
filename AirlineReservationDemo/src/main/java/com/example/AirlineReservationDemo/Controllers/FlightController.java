package com.example.AirlineReservationDemo.Controllers;

import com.example.AirlineReservationDemo.APIResponse.APIResponse;
import com.example.AirlineReservationDemo.Entities.Flight;
import com.example.AirlineReservationDemo.Repositories.FlightRepository;
import com.example.AirlineReservationDemo.Repositories.PassengerRepository;
import com.example.AirlineReservationDemo.Services.FlightService;
import com.example.AirlineReservationDemo.Services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class FlightController
{
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FlightService flightService;

    APIResponse apiResponse=new APIResponse();

    @GetMapping("/flights")
    public ResponseEntity<?> checkFlights()
    {
        List<Flight> list = flightService.getAll();
        return new ResponseEntity<List<Flight>>(list, HttpStatus.OK);
    }

    @GetMapping("/flights/{id}")
    public ResponseEntity<?> checkFlight(@PathVariable String id)
    {
        Flight flight = flightService.getById(id);
        return new ResponseEntity<Flight>(flight,HttpStatus.OK);
    }

    @PostMapping("/flights/post")
    public  APIResponse saveFlight(@RequestBody Flight flight)
    {
        Flight flight1 = flightService.save(flight);
        //apiResponse.setStatusCode("201");
        //apiResponse.setMessage("New Flight added");
        return apiResponse;
    }
    @PutMapping("/flights/update/{id}")
    public APIResponse updateFlight(@PathVariable String id,@RequestBody Flight flight)
    {
        Flight flight1 = flightService.update(id,flight);
        apiResponse.setStatusCode("201");
        apiResponse.setMessage("Flight Details Updated");
        return apiResponse;
    }
    @DeleteMapping("/flights/delete/{id}")
    public APIResponse cancelFlight(@PathVariable String id)
    {
        flightService.delete(id);
        apiResponse.setStatusCode("200");
        apiResponse.setMessage("Flight Cancelled");
        return apiResponse;
    }

}
