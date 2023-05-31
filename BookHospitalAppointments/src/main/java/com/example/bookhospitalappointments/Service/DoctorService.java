package com.example.bookhospitalappointments.Service;

import com.example.bookhospitalappointments.ApiException.ApiException;
import com.example.bookhospitalappointments.Model.Appointment;
import com.example.bookhospitalappointments.Model.Doctor;
import com.example.bookhospitalappointments.Model.Hospitals;
import com.example.bookhospitalappointments.Model.Patient;
import com.example.bookhospitalappointments.Repository.DoctorRepository;
import com.example.bookhospitalappointments.Repository.HospitalsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final HospitalsRepository hospitalsRepository;

    public List<Doctor> doctors(){
        return doctorRepository.findAll();
    }

    public void add(Doctor doctor, Errors errors){
        if(errors.hasErrors())
            throw new ApiException(errors.getFieldError().getDefaultMessage());

        doctorRepository.save(doctor);
    }

    public void update(int id, Doctor doctor, Errors errors){
    }

    public void delete(int id){
        Doctor findDoctor = doctorRepository.findById(id).orElseThrow(()-> new ApiException("id not found"));
        doctorRepository.delete(findDoctor);
    }

    public void assignDoctorToHospitals(int doctor_id, int hospitals_id) {
        Doctor findDoctor = doctorRepository.findById(doctor_id).
                orElseThrow(() -> new ApiException("can't assign Doctor, id is not found"));

        Hospitals findHospitals = hospitalsRepository.findById(hospitals_id).
                orElseThrow(() -> new ApiException("can't assign hospitals, id is not found"));

        findDoctor.setHospitals(findHospitals);

        doctorRepository.save(findDoctor);

    }

}
