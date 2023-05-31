package com.example.bookhospitalappointments.Repository;

import com.example.bookhospitalappointments.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    Appointment findAppointmentById(Integer id);

}
