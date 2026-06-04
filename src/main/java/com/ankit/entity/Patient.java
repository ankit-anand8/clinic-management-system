package com.ankit.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name cannot be null")
    private String name;

    @NotBlank(message = "Email cannot be null")
    @Email(message = "Enter the email in correct format")
    private String email;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$",message = "Phone number must be 10 digits")
    private String phone;

    @Min(1)
    private int age;
}
//Why use Integer instead of int for Entity IDs?
//int is a primitive type and cannot store null.
//Integer is a wrapper class and can store null.

//Rule of thumb:
//For entity primary keys (@Id), prefer Integer (or Long) over int because IDs naturally start as null and are assigned later by the database. ✅