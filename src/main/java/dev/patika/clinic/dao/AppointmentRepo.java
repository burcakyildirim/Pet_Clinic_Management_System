package dev.patika.clinic.dao;

import dev.patika.clinic.entities.Animal;
import dev.patika.clinic.entities.Appointment;
import dev.patika.clinic.entities.Doctor;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDateTimeBetweenAndAnimalId(LocalDateTime startDate, LocalDateTime endDate, Integer animalId);
    List<Appointment> findByDateTimeBetweenAndDoctorId(LocalDateTime startDate, LocalDateTime endDate, Integer doctorId);

}
