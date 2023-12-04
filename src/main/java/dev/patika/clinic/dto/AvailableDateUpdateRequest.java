package dev.patika.clinic.dto;

import dev.patika.clinic.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateUpdateRequest {
    private Long id;
    private LocalDate date;
    private Doctor doctor;
}
