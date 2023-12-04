package dev.patika.clinic.business.concretes;

import dev.patika.clinic.business.abstracts.IAppointmentService;
import dev.patika.clinic.dao.AppointmentRepo;
import dev.patika.clinic.dao.AvailableDateRepo;
import dev.patika.clinic.dao.DoctorRepo;
import dev.patika.clinic.entities.Appointment;
import dev.patika.clinic.entities.AvailableDate;
import dev.patika.clinic.entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentManager implements IAppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Override
    public Appointment getById(Long id) {
        return this.appointmentRepo.findById(id).orElseThrow();
    }

    @Override
    public Appointment save(Appointment appointment) {
        return this.appointmentRepo.save(appointment);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return this.appointmentRepo.save(appointment);
    }

    @Override
    public void delete(Long id) {
        this.appointmentRepo.delete(this.getById(id));
    }

    @Override
    public List<Appointment> findAll() {
        return this.appointmentRepo.findAll();
    }
}
