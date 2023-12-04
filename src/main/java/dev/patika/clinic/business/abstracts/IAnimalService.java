package dev.patika.clinic.business.abstracts;

import dev.patika.clinic.entities.Animal;

import java.util.List;
import java.util.Optional;

public interface IAnimalService {
    Animal getById(Long id);

    Animal save(Animal animal);

    Animal update(Animal animal);

    void delete(Long id);

    List<Animal> findAll();
}
