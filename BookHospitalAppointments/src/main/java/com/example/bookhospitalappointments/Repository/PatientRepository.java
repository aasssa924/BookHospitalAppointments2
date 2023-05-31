package com.example.bookhospitalappointments.Repository;

import com.example.bookhospitalappointments.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    Patient findPatientById(Integer id);
}
