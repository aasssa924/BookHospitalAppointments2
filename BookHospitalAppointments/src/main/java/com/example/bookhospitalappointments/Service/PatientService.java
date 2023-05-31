package com.example.bookhospitalappointments.Service;

import com.example.bookhospitalappointments.ApiException.ApiException;
import com.example.bookhospitalappointments.Model.Patient;
import com.example.bookhospitalappointments.Repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.apache.coyote.ErrorState;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
//    private final Appointment appointment;


    public List<Patient> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

    public void addPatient(Patient patient, Errors errors){
        if (errors.hasErrors()){
            throw new ApiException(errors.getFieldError().getDefaultMessage());
        }
        patientRepository.save(patient);
    }

    public void updatePatient(Patient patient, Errors errors, Integer id){
        Patient oldPatient = patientRepository.findPatientById(id);
        if (errors.hasErrors()){
            throw new ApiException(errors.getFieldError().getDefaultMessage());
        }
        if (oldPatient == null){
            throw new ApiException("Patient not found");
        }
        oldPatient.setName(patient.getName());
        oldPatient.setPhone(patient.getPhone());
        oldPatient.setAge(patient.getAge());
        oldPatient.setEmail(patient.getEmail());

        patientRepository.save(oldPatient);
    }

    public void deletePatient(Integer id){
        Patient patient = patientRepository.findPatientById(id);
        if (patient == null) {
            throw new ApiException("Patient not found");
        }
        patientRepository.delete(patient);
    }

}
