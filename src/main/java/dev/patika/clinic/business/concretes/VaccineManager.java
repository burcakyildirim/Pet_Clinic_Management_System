package dev.patika.clinic.business.concretes;

import dev.patika.clinic.business.abstracts.IVaccineService;
import dev.patika.clinic.dao.AnimalRepo;
import dev.patika.clinic.dao.VaccineRepo;
import dev.patika.clinic.entities.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        String code = vaccine.getCode();
        Integer animalId = Math.toIntExact(vaccine.getAnimal().getId());
        LocalDate startDate = vaccine.getStartDate();

        List<Vaccine> vaccineList = vaccineRepo.findAllByAnimalIdAndCodeAndFinishDateAfter(animalId,code,startDate);

        if(!vaccineList.isEmpty()) {
            throw new RuntimeException("Aşı süresi bitmediği için yeni kayıt yapılamaz.");
        } else {
            return this.vaccineRepo.save(vaccine);
        }
    }
    @Override
    public Vaccine update(Vaccine vaccine) {
        return this.vaccineRepo.save(vaccine);
    }

    @Override
    public void delete(Long id) {
        Vaccine v = vaccineRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " id'li aşı bulunamadı."));
        this.vaccineRepo.delete(this.getById(id));
    }

    @Override
    public List<Vaccine> findAll() {
        return this.vaccineRepo.findAll();
    }
}
