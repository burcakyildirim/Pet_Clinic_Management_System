package dev.patika.clinic.api;

import dev.patika.clinic.business.abstracts.IAnimalService;
import dev.patika.clinic.business.abstracts.IAppointmentService;
import dev.patika.clinic.dao.AppointmentRepo;
import dev.patika.clinic.dao.DoctorRepo;
import dev.patika.clinic.entities.Appointment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class AppointmentController {

    @Autowired
    private final IAppointmentService appointmentService;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AppointmentRepo appointmentRepo;


    @Autowired
    public AppointmentController(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointments")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> findAll() {
        return this.appointmentService.findAll();
    }

    @PostMapping("/appointments")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment save(@RequestBody Appointment appointment) {
        return this.appointmentService.save(appointment);
    }


    @PutMapping("/appointments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment update(@PathVariable Long id, @RequestBody Appointment appointment)  {
        return  this.appointmentService.update(id,appointment);
    }

    @DeleteMapping("/appointments/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.appointmentService.delete(id);
    }

    @GetMapping("/appointments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment getById(@PathVariable("id") Long id) {
        return this.appointmentService.getById(id);
    }


    //Değerlendirme Formu 23(Randevuları girilen tarih aralığına ve hayvana göre getirme işlemi)
    @GetMapping("appointments/dateTime")
    public ResponseEntity<List<Appointment>> getAppointmentsByAnimalId (@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate, @RequestParam Integer animalId) {
        return new ResponseEntity<List<Appointment>>(appointmentRepo.findByDateTimeBetweenAndAnimalId(startDate, endDate, animalId),HttpStatus.OK);
    }

    //Değerlendirme Formu 24(Randevuları girilen tarih aralığına ve doktora göre getirme işlemi)
    @GetMapping("appointments/dateTime/doctorId")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctorId(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate, @RequestParam Integer doctorId) {
        return new ResponseEntity<List<Appointment>>(appointmentRepo.findByDateTimeBetweenAndDoctorId(startDate,endDate,doctorId),HttpStatus.OK);
    }
}
