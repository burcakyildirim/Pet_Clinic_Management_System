package dev.patika.clinic.business.concretes;

import dev.patika.clinic.business.abstracts.IDoctorService;
import dev.patika.clinic.dao.DoctorRepo;
import dev.patika.clinic.entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorManager implements IDoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Override
    public Doctor getById(Long id) {
        return this.doctorRepo.findById(id).orElseThrow();
    }

    @Override
    public Doctor save(Doctor doctor) {
        return this.doctorRepo.save(doctor);
    }

    @Override
    public Doctor update(Doctor doctor) {
        return this.doctorRepo.save(doctor);
    }

    @Override
    public void delete(Long id) {
        this.doctorRepo.delete(this.getById(id));
    }

    @Override
    public List<Doctor> findAll() {
        return this.doctorRepo.findAll();
    }
}
