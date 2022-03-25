package com.example.AirlineReservationDemo.Entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.kafka.common.protocol.types.Field;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @Column
    private String flightNo;
    @Column
    private String airlines;
    @Column
    private String departureCity;
    @Column
    private String arrivalCity;
    @Column
    private String dateOfDeparture;


}
