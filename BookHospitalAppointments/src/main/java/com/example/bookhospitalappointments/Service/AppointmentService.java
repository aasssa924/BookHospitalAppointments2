package com.example.bookhospitalappointments.Service;

import com.example.bookhospitalappointments.ApiException.ApiException;
import com.example.bookhospitalappointments.Model.Appointment;
import com.example.bookhospitalappointments.Model.Patient;
import com.example.bookhospitalappointments.Repository.AppointmentRepository;
import com.example.bookhospitalappointments.Repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;


    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments;
    }

    public void addAppointment(Appointment appointment, Errors errors) {
        if (errors.hasErrors()) {
            throw new ApiException(errors.getFieldError().getDefaultMessage());
        }
        appointmentRepository.save(appointment);
    }

    public void updateAppointment(Appointment appointment, Errors errors, Integer id) {
        Appointment oldAppointment = appointmentRepository.findAppointmentById(id);
        if (errors.hasErrors()) {
            throw new ApiException(errors.getFieldError().getDefaultMessage());
        }
        if (oldAppointment == null) {
            throw new ApiException("Patient not found");
        }
        oldAppointment.setBookingDate(appointment.getBookingDate());

        appointmentRepository.save(oldAppointment);
    }

    public void deleteAppointment(Integer id) {
        Appointment appointment = appointmentRepository.findAppointmentById(id);
        if (appointment == null) {
            throw new ApiException("Patient not found");
        }
        appointmentRepository.delete(appointment);
    }

    public void assignAppointmentToPatient(int appointment_id, int patient_id) {
        Appointment findAppointment = appointmentRepository.findById(appointment_id).
                orElseThrow(() -> new ApiException("can't assign Appointment, id is not found"));

        Patient findPatient = patientRepository.findById(patient_id).
                orElseThrow(() -> new ApiException("can't assign Patient, id is not found"));

        findAppointment.setPatient(findPatient);

        appointmentRepository.save(findAppointment);

    }
}