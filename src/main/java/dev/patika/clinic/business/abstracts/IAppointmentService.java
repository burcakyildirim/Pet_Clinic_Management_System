package dev.patika.clinic.business.abstracts;

import dev.patika.clinic.entities.Animal;
import dev.patika.clinic.entities.Appointment;
import dev.patika.clinic.entities.AvailableDate;
import dev.patika.clinic.entities.Doctor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IAppointmentService {
    Appointment getById(Long id);

    Appointment save(Appointment appointment);

    Appointment update(Long id,Appointment appointment);

    void delete(Long id);

    List<Appointment> findAll();
}
