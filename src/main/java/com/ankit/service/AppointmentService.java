package com.ankit.service;

import com.ankit.entity.Appointment;
import com.ankit.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import com.ankit.dto.AppointmentDTO;
import com.ankit.entity.Doctor;
import com.ankit.entity.Patient;
import com.ankit.repository.DoctorRepository;
import com.ankit.repository.PatientRepository;

import java.util.List;

@Service
public class AppointmentService {
    private AppointmentRepository repo;

    private PatientRepository patientRepo;
    private DoctorRepository doctorRepo;

    public AppointmentService(AppointmentRepository repo, PatientRepository patientRepo,
                              DoctorRepository doctorRepo){
        this.repo=repo;
        this.patientRepo=patientRepo;
        this.doctorRepo=doctorRepo;
    }

    public Appointment saveAppointment(Appointment appointment){
        return repo.save(appointment);
    }

    public List<Appointment> getAllAppointments(){
        return repo.findAll();
    }

    public Appointment getAppointmentById(int id){
        return repo.findById(id).orElseThrow(()->new RuntimeException("No Appointment found"));
    }

    public Appointment updateAppointments(int id,Appointment appointment){
        Appointment existingAppointment=repo.findById(id).orElseThrow(()->new RuntimeException("No Appointment found"));

        existingAppointment.setStatus(appointment.getStatus());
        existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
        existingAppointment.setPatient(appointment.getPatient());
        existingAppointment.setDoctor(appointment.getDoctor());

        return repo.save(existingAppointment);
    }

    public void deleteAppointmentById(int id){
        repo.deleteById(id);
    }

    public Appointment saveAppointment(AppointmentDTO dto){

        Patient patient = patientRepo.findById(dto.getPatientId()).orElseThrow(() ->new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepo.findById(dto.getDoctorId()).orElseThrow(() ->new RuntimeException("Doctor not found"));

        Appointment appointment = new Appointment();

        appointment.setStatus(dto.getStatus());
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return repo.save(appointment);
    }
}
//We are not updating the Doctor or Patient records themselves.
//We are updating the relationship of the appointment, not the actual patient or doctor data.

//For example:
//Suppose:
//
//Doctor 1 = Dr. Sharma
//Doctor 2 = Dr. Roy
//
//And Appointment 101 is currently linked to Doctor 1.

//If you send:
//
// {
//   "status":"BOOKED",
//   "appointmentDate":"2026-06-15",
//   "doctor":{
//     "id":2
//   }
// }
//
//then:
//
//existingAppointment.setDoctor(appointment.getDoctor());
//changes the appointment's doctor from Doctor 1 to Doctor 2.

//It does not modify:
//
//Doctor 1's name
//Doctor 2's name
//Doctor 1's specialization
//Doctor 2's specialization
//
//It only changes the relationship.