package com.example.AirlineReservationDemo.Services;

import com.example.AirlineReservationDemo.CustomException.ValidationException;
import com.example.AirlineReservationDemo.Entities.Flight;
import com.example.AirlineReservationDemo.Repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService
{
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAll() {
        List<Flight> list = flightRepository.findAll();
        return list;
    }

    public Flight save(Flight flight) {
        if(flight.getFlightNo().isEmpty()||flight.getAirlines().isEmpty()
                ||flight.getDepartureCity().isEmpty()||flight.getArrivalCity().isEmpty()||flight.getDateOfDeparture().isEmpty())
        {
            throw new ValidationException();
        }
        Flight flight1=flightRepository.save(flight);
        return flight;
    }

    public Flight getById(String id) {
        return flightRepository.findById(id).get();
    }

    public Flight update(String id, Flight flight) {
        Flight updateFlight = flightRepository.findById(id).get();
        updateFlight.setFlightNo(flight.getFlightNo());
        updateFlight.setAirlines(flight.getAirlines());
        updateFlight.setDepartureCity(flight.getDepartureCity());
        updateFlight.setArrivalCity(flight.getArrivalCity());
        updateFlight.setDateOfDeparture(flight.getDateOfDeparture());

        flightRepository.save(updateFlight);
        return updateFlight;
    }

    public void delete(String id) {
        flightRepository.deleteById(id);
    }
}

