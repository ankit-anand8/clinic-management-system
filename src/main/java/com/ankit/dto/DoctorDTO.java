package com.ankit.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {

    private Integer id;
    private String name;
    private String specialization;
    private String phone;
}
