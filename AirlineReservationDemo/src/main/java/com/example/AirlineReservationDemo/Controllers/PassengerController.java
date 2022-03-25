package com.example.AirlineReservationDemo.Controllers;
import com.example.AirlineReservationDemo.APIResponse.APIResponse;
import com.example.AirlineReservationDemo.Entities.Passenger;
import com.example.AirlineReservationDemo.Repositories.PassengerRepository;
import com.example.AirlineReservationDemo.Services.PassengerService;
import org.slf4j.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import static org.slf4j.LoggerFactory.*;
//import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class PassengerController {

    Logger LOGGER = logger(PassengerController.class);

    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private PassengerService passengerService;
    //Kafka Service
    @Autowired
    private KafkaTemplate<String,Object> template;

    private String topic2 = "check-flight";

    APIResponse response = new APIResponse();
    @GetMapping("/passengers/get")
    public ResponseEntity<?> viewPassengers()
    {
        LOGGER.info("Passengers List is viewed");
        List<Passenger> list = passengerService.getall();
        return new ResponseEntity<List<Passenger>>(list, HttpStatus.OK);

    }
    @GetMapping("/passengers/{id}")
    public ResponseEntity<?> viewById(@PathVariable(value = "id")String id)
    {
        LOGGER.infof("Passenger %s Data is viewed",id);
        Passenger passenger = passengerService.getById(id);
        return new ResponseEntity<Passenger>(passenger,HttpStatus.OK);
    }
    @PostMapping("/passengers/post")
    public APIResponse bookPassenger(@RequestBody Passenger passenger)
    {
        LOGGER.info("New Booking Made");
        Passenger passenger1 = passengerService.save(passenger);
        response.setStatusCode("201");
        response.setMessage("Booking Confirmed");
        //template.send(topic2,"Hello passenger your Ticket is Confirmed");
        return response;
    }
    @DeleteMapping("/passengers/delete/{id}")
    public APIResponse cancelPassenger(@PathVariable String id)
    {
        LOGGER.infof("Passenger %s canceled",id);
        passengerService.delete(id);
        response.setStatusCode("201");
        response.setMessage("Booking Cancelled");
        return response;
    }
    @PutMapping("/passengers/update/{id}")
    public APIResponse updatePassenger(@PathVariable String id, @RequestBody Passenger passenger)
    {
        LOGGER.infof("Passenger %s data is Updated",id);
        Passenger passenger1 = passengerService.update(id,passenger);
        response.setStatusCode("201");
        response.setMessage("Passenger Details Updated");
        return response;
    }


}
