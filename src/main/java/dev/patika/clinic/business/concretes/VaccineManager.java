package dev.patika.clinic.business.concretes;

import dev.patika.clinic.business.abstracts.IVaccineService;
import dev.patika.clinic.dao.AnimalRepo;
import dev.patika.clinic.dao.VaccineRepo;
import dev.patika.clinic.entities.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VaccineManager implements IVaccineService {

    @Autowired
    private VaccineRepo vaccineRepo;

    @Override
    public Vaccine getById(Long id) {
        return this.vaccineRepo.findById(id).orElseThrow();
    }

    @Override
    public Vaccine save(Vaccine vaccine) {
        Vaccine existingVaccine = vaccineRepo.findByCodeAndFinishDate(vaccine.getCode(), vaccine.getFinishDate());
        if (existingVaccine != null && !existingVaccine.getFinishDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Vaccine already exists and has not expired.");
        }
        return this.vaccineRepo.save(vaccine);
    }

    @Override
    public Vaccine update(Vaccine vaccine) {
        return this.vaccineRepo.save(vaccine);
    }

    @Override
    public void delete(Long id) {
        this.vaccineRepo.delete(this.getById(id));
    }

    @Override
    public List<Vaccine> findAll() {
        return this.vaccineRepo.findAll();
    }
}
