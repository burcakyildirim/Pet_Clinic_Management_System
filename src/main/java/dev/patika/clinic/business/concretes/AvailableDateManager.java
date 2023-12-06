package dev.patika.clinic.business.concretes;

import dev.patika.clinic.business.abstracts.IAvailableDateService;
import dev.patika.clinic.dao.AvailableDateRepo;
import dev.patika.clinic.entities.AvailableDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableDateManager implements IAvailableDateService {

    @Autowired
    private AvailableDateRepo availableDateRepo;

    @Override
    public AvailableDate getById(Long id) {
        return this.availableDateRepo.findById(id).orElseThrow();
    }

    @Override
    public AvailableDate save(AvailableDate availableDate) {
        return this.availableDateRepo.save(availableDate);
    }

    @Override
    public AvailableDate update(AvailableDate availableDate) {
        return this.availableDateRepo.save(availableDate);
    }

    @Override
    public void delete(Long id) {
        AvailableDate av = availableDateRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " id'li doktora ait uygun gün bulunamadı."));
        this.availableDateRepo.delete(this.getById(id));
    }

    @Override
    public List<AvailableDate> findAll() {
        return this.availableDateRepo.findAll();
    }
}
