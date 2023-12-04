package dev.patika.clinic.dto;

import dev.patika.clinic.business.abstracts.ICustomerService;
import dev.patika.clinic.entities.Animal;
import dev.patika.clinic.entities.Appointment;
import dev.patika.clinic.entities.Customer;
import dev.patika.clinic.entities.Vaccine;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalSaveRespond {
    private Long id;
    private String name;
    private String species;
    private String breed;
    private Animal.GENDER gender;
    private String colour;
    private LocalDate date;
}
