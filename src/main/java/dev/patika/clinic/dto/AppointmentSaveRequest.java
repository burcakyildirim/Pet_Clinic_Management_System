package dev.patika.clinic.dto;

import dev.patika.clinic.entities.Animal;
import dev.patika.clinic.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentSaveRequest {
    private LocalDateTime dateTime;
    private Animal animal;
    private Doctor doctor;
}
