package dev.patika.clinic.dto;

import dev.patika.clinic.entities.Animal;
import dev.patika.clinic.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalSaveRequest {
    private String name;
    private String species;
    private String breed;
    private Animal.GENDER gender;
    private String colour;
    private LocalDate date;
    private Customer customer;
}