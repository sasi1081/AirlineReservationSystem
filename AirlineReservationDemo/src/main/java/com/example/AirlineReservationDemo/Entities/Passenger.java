package com.example.AirlineReservationDemo.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    @Id
    @Column
    private String passportNo;
    @Column
    @Size(min=2,message = "FirstName Requires at least 2 characters")
    @Pattern(regexp = "([A-Z][a-z]*)([\\\\s\\\\\\'-][A-Z][a-z]*)*")
    private String firstName;
    @Column
    @Size(min=2,message = "LastName Requires at least 2 characters")
    @Pattern(regexp = "([A-Z][a-z]*)([\\\\s\\\\\\'-][A-Z][a-z]*)*")
    private String lastName;
    @Column
    private String flightNo;
    @Column
    private String eMAil;
    @Column
    private String phone;

}
