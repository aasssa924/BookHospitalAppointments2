package com.example.bookhospitalappointments.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Patient name must be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty(message = "Patient phone must be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String phone;

    @NotNull(message ="Patient age must be not empty" )
    @Positive(message = "Enter positive number")
    @Column(columnDefinition = "Int not null")
    private Integer age;

    @NotEmpty(message = "Email must be not empty")
    @Email(message = "Enter valid email")
    @Column(columnDefinition = "varchar(20) not null")
    private String email;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "patient")
    private Set<Appointment> appointmentSet;

}
