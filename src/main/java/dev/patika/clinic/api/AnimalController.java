package dev.patika.clinic.api;

import dev.patika.clinic.business.abstracts.IAnimalService;
import dev.patika.clinic.dao.AnimalRepo;
import dev.patika.clinic.dao.CustomerRepo;
import dev.patika.clinic.dto.AnimalSaveRequest;
import dev.patika.clinic.dto.AnimalSaveRespond;
import dev.patika.clinic.dto.AnimalUpdateRequest;
import dev.patika.clinic.entities.Animal;
import dev.patika.clinic.entities.Customer;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class AnimalController {
    @Autowired
    private final IAnimalService animalService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AnimalRepo animalRepo;

    @Autowired
    public AnimalController(IAnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animals")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalSaveRespond> findAll() {
        List<AnimalSaveRespond> animalSaveRespondList = this.animalService.findAll().stream().map(
                animal -> this.modelMapper.map(animal,AnimalSaveRespond.class)
        ).collect(Collectors.toList());
        return animalSaveRespondList;
    }

    @PostMapping("/animals")
    @ResponseStatus(HttpStatus.CREATED)
    public Animal save(@RequestBody AnimalSaveRequest animalSaveRequest) {
        Animal newAnimal = this.modelMapper.map(animalSaveRequest,Animal.class);
        return this.animalService.save(newAnimal);
    }

    @PutMapping("/animals")
    @ResponseStatus(HttpStatus.OK)
    public Animal update(@RequestBody AnimalUpdateRequest animalUpdateRequest) {
        Animal updatedAnimal = this.animalService.getById(animalUpdateRequest.getId());
        updatedAnimal.setName(animalUpdateRequest.getName());
        updatedAnimal.setSpecies(animalUpdateRequest.getSpecies());
        updatedAnimal.setBreed(animalUpdateRequest.getBreed());
        updatedAnimal.setGender(animalUpdateRequest.getGender());
        updatedAnimal.setColour(animalUpdateRequest.getColour());
        updatedAnimal.setDate(animalUpdateRequest.getDate());
        return this.animalService.update(updatedAnimal);
    }

    @DeleteMapping("/animals/{id}")
    public void delete(@PathVariable("id")Long id) {
        this.animalService.delete(id);
    }

    @GetMapping("/animals/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal getById(@PathVariable("id") Long id) {
        return this.animalService.getById(id);
    }

    @GetMapping("/animals/name")
    public ResponseEntity<List<Animal>> getAnimalByName(@RequestParam String name) {
        return new ResponseEntity<List<Animal>>(animalRepo.findByName(name),HttpStatus.OK);
    }

    @GetMapping("/animals/customerId")
    public ResponseEntity<List<Animal>> getAnimalsByCustomerId(@RequestParam Integer customerId) {
        return new ResponseEntity<List<Animal>>(animalRepo.findByCustomerId(customerId),HttpStatus.OK);
    }
}
