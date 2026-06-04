package com.ankit.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String status;

    @NotNull
    private LocalDate appointmentDate;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;
}

//Why do we write Doctor doctor instead of int doctorId in the entity?
//
//Answer:
//JPA works with objects, not foreign key values directly. We model the relationship using the Doctor object, and Hibernate automatically manages the doctor_id foreign key column in the database.
//
//So:
//private Doctor doctor;
//✅ JPA way
//
//instead of:
//private int doctorId;
//❌ Not using object relationships.