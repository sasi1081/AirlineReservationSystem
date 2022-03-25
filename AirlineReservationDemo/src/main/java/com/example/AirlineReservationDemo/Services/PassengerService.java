package com.example.AirlineReservationDemo.Services;

import com.example.AirlineReservationDemo.CustomException.ValidationException;
import com.example.AirlineReservationDemo.Entities.Passenger;
import com.example.AirlineReservationDemo.Repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getall()
    {
        List<Passenger> list =passengerRepository.findAll();
        return list;
    }

    public Passenger getById( String id)
    {
        return passengerRepository.findById(id).get();
    }

    public Passenger save(@Valid Passenger passenger)
    {
        if(passenger.getPassportNo().isEmpty()||passenger.getLastName().isEmpty()||
                passenger.getFirstName().isEmpty()||passenger.getFlightNo().isEmpty()||
                passenger.getEMAil().isEmpty()||passenger.getPhone().isEmpty())
        {
            throw new ValidationException();
        }
        Passenger passenger1=passengerRepository.save(passenger);
        return passenger1;
    }

    public void delete(String id)
    {
        passengerRepository.deleteById(id);
    }

    public Passenger update(@Valid String id, Passenger passenger)
    {
     Passenger updatePassenger = passengerRepository.findById(id).get();
     updatePassenger.setPassportNo(passenger.getPassportNo());
     updatePassenger.setFirstName(passenger.getFirstName());
     updatePassenger.setLastName(passenger.getLastName());
     updatePassenger.setFlightNo(passenger.getFlightNo());
     updatePassenger.setEMAil(passenger.getEMAil());
     updatePassenger.setPhone(passenger.getPhone());

     passengerRepository.save(updatePassenger);
     return updatePassenger;
    }

}
