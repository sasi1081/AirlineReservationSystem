package com.example.AirlineReservationDemo.Repositories;

import com.example.AirlineReservationDemo.Entities.Flight;
import com.example.AirlineReservationDemo.Entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight,String> {
}
