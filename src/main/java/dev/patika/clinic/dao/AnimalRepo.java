package dev.patika.clinic.dao;

import dev.patika.clinic.entities.Animal;
import dev.patika.clinic.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Long> {

    //Hayvanları isme göre filtreleyen query
    List<Animal> findByName(String name);


    //(Sadece bir hayvan sahibine ait tüm hayvanları filtreleyen query
    List<Animal> findByCustomerId(Integer customerId);
}
