package dev.patika.clinic.business.abstracts;

import dev.patika.clinic.dao.AvailableDateRepo;
import dev.patika.clinic.entities.AvailableDate;

import java.util.List;

public interface IAvailableDateService {

    AvailableDate getById(Long id);

    AvailableDate save(AvailableDate availableDate);

    AvailableDate update(AvailableDate availableDate);

    void delete(Long id);

    List<AvailableDate> findAll();
}
