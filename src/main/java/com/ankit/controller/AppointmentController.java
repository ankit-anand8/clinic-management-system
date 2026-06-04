package com.ankit.controller;

import com.ankit.entity.Appointment;
import com.ankit.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    private AppointmentService service;
    public AppointmentController(AppointmentService service){
        this.service=service;
    }

    @PostMapping("/appointments")
    public Appointment addAppointment(@Valid @RequestBody Appointment appointment){
        return service.saveAppointment(appointment);
    }

    @GetMapping ("/appointments")
    public List<Appointment> getAllAppointment(){
        return service.getAllAppointments();
    }

    @GetMapping("/appointments/{id}")
    public Appointment getAppointmentById(@PathVariable int id){
        return service.getAppointmentById(id);
    }

    @PutMapping("/appointments/{id}")
    public Appointment updateAppointments(@PathVariable int id, @Valid @RequestBody Appointment appointment){
        return service.updateAppointments(id,appointment);
    }

    @DeleteMapping("/appointments/{id}")
    public String deleteAppointment(@PathVariable int id){
        service.deleteAppointmentById(id);
        return "Appointment deleted successfully";
    }
}
