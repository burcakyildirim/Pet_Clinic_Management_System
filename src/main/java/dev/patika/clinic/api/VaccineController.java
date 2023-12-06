package dev.patika.clinic.api;

import dev.patika.clinic.business.abstracts.IVaccineService;
import dev.patika.clinic.business.concretes.VaccineManager;
import dev.patika.clinic.dao.VaccineRepo;
import dev.patika.clinic.dto.VaccineRespond;
import dev.patika.clinic.dto.VaccineSaveRequest;
import dev.patika.clinic.dto.VaccineUpdateRequest;
import dev.patika.clinic.entities.Vaccine;
import jakarta.servlet.http.PushBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class VaccineController {

    @Autowired
    private final IVaccineService vaccineService;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private VaccineRepo vaccineRepo;

    @Autowired
    private VaccineManager vaccineManager;

    @Autowired
    public VaccineController(IVaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping("/vaccines")
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineRespond> findAll() {
        List<VaccineRespond> vaccineRespondList = this.vaccineService.findAll().stream().map(
                vaccine -> this.modelMapper.map(vaccine,VaccineRespond.class)
        ).collect(Collectors.toList());
        return vaccineRespondList;
    }

    @PostMapping("/vaccines")
    @ResponseStatus(HttpStatus.CREATED)
    public Vaccine save(@RequestBody Vaccine vaccine) {
        return this.vaccineService.save(vaccine);
    }

    @PutMapping("/vaccines")
    @ResponseStatus(HttpStatus.OK)
    public Vaccine update(@RequestBody VaccineUpdateRequest vaccineUpdateRequest) {
        Vaccine updatedVaccine = this.vaccineService.getById(vaccineUpdateRequest.getId());
        updatedVaccine.setName(updatedVaccine.getName());
        updatedVaccine.setCode(updatedVaccine.getCode());
        updatedVaccine.setStartDate(updatedVaccine.getStartDate());
        updatedVaccine.setFinishDate(updatedVaccine.getFinishDate());
        return this.vaccineService.update(updatedVaccine);
    }

    @DeleteMapping("/vaccines/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.vaccineService.delete(id);
    }

    @GetMapping("/vaccines/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vaccine getById(@PathVariable("id") Long id) {
        return this.vaccineService.getById(id);
    }

    @GetMapping("/vaccines/animalId")
    public ResponseEntity<List<Vaccine>> getVaccinesByAnimalId(@RequestParam Integer animalId) {
        return new ResponseEntity<List<Vaccine>>(vaccineRepo.findByAnimalId(animalId),HttpStatus.OK);
    }

    @GetMapping("/vaccines/finishDate")
    public ResponseEntity<List<Vaccine>> getVaccinesByFinishDate(@RequestParam LocalDate startDate, @RequestParam  LocalDate endDate) {
        return new ResponseEntity<List<Vaccine>>(vaccineRepo.findByFinishDateBetween(startDate, endDate),HttpStatus.OK);
    }
}
