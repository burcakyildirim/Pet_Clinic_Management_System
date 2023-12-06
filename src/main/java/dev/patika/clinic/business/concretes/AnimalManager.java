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
        return this.animalRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " id'li hayvan bulunamadı."));
    }

    @Override
    public Animal save(Animal animal) {
        return this.animalRepo.save(animal);
    }

    @Override
    public Animal update(Long id,Animal animal) {
        Optional<Animal> animalFromDb = animalRepo.findById(id);

        if(animalFromDb.isEmpty()) {
            throw new RuntimeException(id + "Güncelleme çalıştığınız hayvan sistemde bulunamadı!");
        }
        animal.setId(id);
        return this.animalRepo.save(animal);
    }

    @Override
    public void delete(Long id) {
        Animal a = animalRepo.findById(id).orElseThrow(() ->
        new RuntimeException(id + " id'li hayvan sistemde bulunamadı!"));
        this.animalRepo.delete(this.getById(id));
    }

    @Override
    public List<Animal> findAll() {
        return this.animalRepo.findAll();
    }
}
