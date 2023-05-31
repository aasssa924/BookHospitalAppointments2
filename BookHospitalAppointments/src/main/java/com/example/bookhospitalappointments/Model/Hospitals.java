package com.example.bookhospitalappointments.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Hospitals {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String City;

    @NotBlank
    private String location;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "hospitals")
    private Set<Doctor> doctorSet;

}

