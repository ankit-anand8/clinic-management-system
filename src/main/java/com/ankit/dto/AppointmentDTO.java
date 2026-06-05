package com.ankit.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentDTO {

    @NonNull
    private Integer patientId;
    @NonNull
    private Integer doctorId;
    @NotBlank
    private String status;
    @NotNull
    private LocalDate appointmentDate;

}
