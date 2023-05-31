package com.example.bookhospitalappointments.Repository;

import com.example.bookhospitalappointments.Model.Hospitals;
import com.example.bookhospitalappointments.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalsRepository extends JpaRepository<Hospitals, String> {
//    Hospitals findHospitalsById(Integer id);


}
