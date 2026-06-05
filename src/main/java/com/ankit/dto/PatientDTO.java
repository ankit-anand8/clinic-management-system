package com.ankit.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private Integer id;
    private String name;
    private String email;
    private String phone;
}

//Age is hidden