package com.example.bookhospitalappointments.Controller;

import com.example.bookhospitalappointments.Model.Doctor;
import com.example.bookhospitalappointments.Service.DoctorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/doctor")
@AllArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/getAll")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(doctorService.doctors());
    }

    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody Doctor doctor, Errors errors){
        doctorService.add(doctor, errors);
        return ResponseEntity.status(200).body("Success");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id, @Valid @RequestBody Doctor doctor, Errors errors){
        doctorService.update(id, doctor, errors);
        return ResponseEntity.status(200).body("Success");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        doctorService.delete(id);
        return ResponseEntity.status(200).body("Success");
    }

    @PutMapping("/{doctor_id}/hospitals/{hospitals_id}")
    public ResponseEntity assignDoctorToHospitals(@PathVariable int doctor_id, @PathVariable int hospitals_id){
        doctorService.assignDoctorToHospitals(doctor_id, hospitals_id);
        return ResponseEntity.status(200).body("assign hospitals to doctor success");
    }
}