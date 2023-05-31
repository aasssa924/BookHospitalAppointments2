package com.example.bookhospitalappointments.Controller;

import com.example.bookhospitalappointments.Model.Hospitals;
import com.example.bookhospitalappointments.Service.HospitalsServies;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalsController {

    private final HospitalsServies hospitalsServies;


    @GetMapping("/get")
    public ResponseEntity getAll(){
        List<Hospitals> hospitalsList = hospitalsServies.getAll();
        return ResponseEntity.status(200).body(hospitalsList);
    }

    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody Hospitals hospital, Errors errors){
        hospitalsServies.add(hospital, errors);
        return ResponseEntity.status(200).body("success");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable String id, @Valid @RequestBody Hospitals hospital, Errors errors){
        hospitalsServies.update(id, hospital, errors);
        return ResponseEntity.status(200).body("success");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        hospitalsServies.delete(id);
        return ResponseEntity.status(200).body("success");
    }

}