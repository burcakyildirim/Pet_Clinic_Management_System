package dev.patika.clinic.dao;

import dev.patika.clinic.entities.Animal;
import dev.patika.clinic.entities.Appointment;
import dev.patika.clinic.entities.Doctor;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

    //Randevuları girilen tarih aralığına ve hayvana göre filtreleyen query
    List<Appointment> findByDateTimeBetweenAndAnimalId(LocalDateTime startDate, LocalDateTime endDate, Integer animalId);

    //Randevuları girilen tarih aralığına ve doktora göre filtreleyen query
    List<Appointment> findByDateTimeBetweenAndDoctorId(LocalDateTime startDate, LocalDateTime endDate, Integer doctorId);

    //Doktorun müsait gününde o saatte başka bir randevusu var mı filtrelemesini yapan query
    boolean existsByDoctorIdAndDateTime(Integer doctorId, LocalDateTime dateTime);

}
