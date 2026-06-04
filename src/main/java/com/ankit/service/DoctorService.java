package com.ankit.service;

import com.ankit.entity.Doctor;
import com.ankit.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private DoctorRepository repo;

    public DoctorService (DoctorRepository repo){
        this.repo=repo;
    }
    public Doctor saveDoctor(Doctor doc){
        return repo.save(doc);
    }

    public List<Doctor> getAllDoctors(){
        return repo.findAll();
    }

    public Doctor getDoctorById(int id){
        return repo.findById(id).orElseThrow(()->new RuntimeException("Doctor not found"));
    }
    public Doctor updateDoctor(int id,Doctor doc){
        Doctor existingDoctor = repo.findById(id).orElseThrow(()->new RuntimeException("Doctor not found"));
        existingDoctor.setName(doc.getName());
        existingDoctor.setSpecialization(doc.getSpecialization());
        existingDoctor.setEmail(doc.getEmail());
        existingDoctor.setPhone(doc.getPhone());

        return repo.save(existingDoctor);
    }

    public void deleteDoctorByID(int id){
        repo.deleteById(id);
    }
}
