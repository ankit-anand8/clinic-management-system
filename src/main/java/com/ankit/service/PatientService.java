package com.ankit.service;

import com.ankit.entity.Patient;
import com.ankit.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository repo;
    public PatientService(PatientRepository repo){
        this.repo=repo;
    }

    public Patient savePatient(Patient p){
        return repo.save(p);
    }

    public List<Patient> getAllPatients(){
        return repo.findAll();
    }

    public Patient getPatientById(int id){
        return repo.findById(id).orElseThrow(()->new RuntimeException("Patient not found"));
    }

    public void deletePatientById(int id){
        repo.deleteById(id);
    }

    //update Patient
    public Patient updatePatient(int id,Patient p){
        Patient existingPatient=repo.findById(id).orElseThrow(()->new RuntimeException("Patient not found"));

        existingPatient.setName(p.getName());
        existingPatient.setEmail(p.getEmail());
        existingPatient.setPhone(p.getPhone());
        existingPatient.setAge(p.getAge());

        return repo.save(existingPatient);
    }
}
