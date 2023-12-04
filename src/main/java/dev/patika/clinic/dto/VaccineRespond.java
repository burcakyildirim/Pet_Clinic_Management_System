package dev.patika.clinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccineRespond {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate finishDate;
}
