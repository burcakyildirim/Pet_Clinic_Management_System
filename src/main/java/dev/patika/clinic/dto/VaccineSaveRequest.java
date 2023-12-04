package dev.patika.clinic.dto;

import dev.patika.clinic.entities.Animal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineSaveRequest {
    private String name;
    private String code;
    private LocalDate startDate;
    private LocalDate finishDate;
    private Animal animal;
}
