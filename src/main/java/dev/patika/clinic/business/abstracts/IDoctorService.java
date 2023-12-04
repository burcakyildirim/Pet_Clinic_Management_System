package dev.patika.clinic.business.abstracts;

import dev.patika.clinic.entities.Doctor;
import java.util.List;

public interface IDoctorService {
    Doctor getById(Long id);

    Doctor save(Doctor doctor);

    Doctor update(Doctor doctor);

    void delete(Long id);

    List<Doctor> findAll();
}
