package com.example.bookhospitalappointments.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @NotEmpty(message = "bookingDate name must be not null")
    @Column(columnDefinition = "varchar(20) not null")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
//    @Pattern(regexp = "^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}$")
    private Date bookingDate;

    private String status;


    @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    @JsonIgnore
    private Patient patient;
}
