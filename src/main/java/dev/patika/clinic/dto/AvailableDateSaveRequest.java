package dev.patika.clinic.dto;

import dev.patika.clinic.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailableDateSaveRequest {
    private Long id;
    private LocalDate date;
    private Doctor doctor;
}
