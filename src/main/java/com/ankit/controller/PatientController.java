package com.ankit.controller;
import java.util.*;
import com.ankit.entity.Patient;
import com.ankit.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private PatientService service;
    public PatientController(PatientService service){
        this.service=service;
    }

    @PostMapping("/patients")
    public Patient addPatient(@Valid @RequestBody Patient patient){
        return service.savePatient(patient);
    }

    @GetMapping("/patients")
    public List<Patient>  allPatients(){
        return service.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable int id){
        return service.getPatientById(id);
    }

    @PutMapping("/patients/{id}")
    public Patient updatePatient(@PathVariable int id,@Valid @RequestBody Patient patient){
        return service.updatePatient(id, patient);
    }

    @DeleteMapping("/patients/{id}")
    public String deletePatient(@PathVariable int id){
        service.deletePatientById(id);
        return "Patient Record deleted successfully";
    }
}
