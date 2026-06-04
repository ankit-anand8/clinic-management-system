package com.ankit.controller;

import com.ankit.entity.Doctor;
import com.ankit.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {
    private DoctorService service;
    public DoctorController(DoctorService service){
        this.service=service;
    }

    @PostMapping("/doctors")
    public Doctor addDoctor(@Valid @RequestBody Doctor doc){
        return service.saveDoctor(doc);
    }

    @GetMapping("/doctors")
    public List<Doctor> allDoctors(){
        return service.getAllDoctors();
    }

    @GetMapping("/doctors/{id}")
    public Doctor getDoctorByID(@PathVariable int id){
        return service.getDoctorById(id);
    }

    @PutMapping("/doctors/{id}")
    public Doctor updateDoctor(@PathVariable int id,@Valid @RequestBody Doctor doc){
        return service.updateDoctor(id,doc);
    }

    @DeleteMapping("/doctors/{id}")
    public String deleteDoctorById(@PathVariable int id){
        service.deleteDoctorByID(id);
        return "Doctor records deleted successfully";
    }
}
