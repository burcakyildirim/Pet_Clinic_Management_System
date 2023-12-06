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
    List<Animal> findByName(String name);

    List<Animal> findByCustomerId(Integer customerId);
}
