package com.example.bookhospitalappointments.Controller;

import com.example.bookhospitalappointments.Model.Appointment;
import com.example.bookhospitalappointments.Model.Patient;
import com.example.bookhospitalappointments.Service.AppointmentService;
import com.example.bookhospitalappointments.Service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/appointment")
@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/get")
    public ResponseEntity getAllAppointment(){
        List<Appointment> allAppointments=appointmentService.getAllAppointments();
        return ResponseEntity.status(200).body(allAppointments);
    }

    @PostMapping("/add")
    public ResponseEntity addAppointment(@Valid @RequestBody Appointment appointment , Errors errors){
        appointmentService.addAppointment(appointment,errors);
        return ResponseEntity.status(200).body("Appointment added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateAppointment(@Valid @RequestBody Appointment appointment, Errors errors ,@Valid @PathVariable Integer id){
        appointmentService.updateAppointment(appointment,errors,id);
        return ResponseEntity.status(200).body("Appointment updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAppointment(@PathVariable @Valid Integer id){
        appointmentService.deleteAppointment(id);
        return ResponseEntity.status(200).body("Appointment deleted");
    }

    @PutMapping("/{appointment_id}/patient/{patient_id}")
    public ResponseEntity assignCourseToTeacher(@PathVariable int appointment_id, @PathVariable int patient_id){
        appointmentService.assignAppointmentToPatient(appointment_id, patient_id);
        return ResponseEntity.status(200).body("assign appointment to patient success");
    }

}
