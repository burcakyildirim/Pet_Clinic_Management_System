package dev.patika.clinic.business.concretes;

import dev.patika.clinic.business.abstracts.IAnimalService;
import dev.patika.clinic.dao.AnimalRepo;
import dev.patika.clinic.entities.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalManager implements IAnimalService {

    @Autowired
    private AnimalRepo animalRepo;

    @Override
    public Animal getById(Long id) {
        return this.animalRepo.findById(id).orElseThrow();
    }

    @Override
    public Animal save(Animal animal) {
        return this.animalRepo.save(animal);
    }

    @Override
    public Animal update(Animal animal) {
        return this.animalRepo.save(animal);
    }

    @Override
    public void delete(Long id) {
        this.animalRepo.delete(this.getById(id));
    }

    @Override
    public List<Animal> findAll() {
        return this.animalRepo.findAll();
    }
}