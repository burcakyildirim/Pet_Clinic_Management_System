package dev.patika.clinic.api;

import dev.patika.clinic.business.abstracts.IAnimalService;
import dev.patika.clinic.business.abstracts.IAppointmentService;
import dev.patika.clinic.dao.AppointmentRepo;
import dev.patika.clinic.dto.AppointmentResponse;
import dev.patika.clinic.dto.AppointmentSaveRequest;
import dev.patika.clinic.dto.AppointmentUpdateRequest;
import dev.patika.clinic.entities.Animal;
import dev.patika.clinic.entities.Appointment;
import dev.patika.clinic.entities.Doctor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<AppointmentResponse> findAll() {
        List<AppointmentResponse> appointmentResponseList = this.appointmentService.findAll().stream().map(
                appointment -> this.modelMapper.map(appointment,AppointmentResponse.class)
        ).collect(Collectors.toList());
        return appointmentResponseList;
    }

    @PostMapping("/appointments")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment save(@RequestBody AppointmentSaveRequest appointmentSaveRequest) {
        Appointment newAppointment = this.modelMapper.map(appointmentSaveRequest,Appointment.class);
        return this.appointmentService.save(newAppointment);
    }

    @PutMapping("/appointments")
    @ResponseStatus(HttpStatus.OK)
    public Appointment update(@RequestBody AppointmentUpdateRequest appointmentUpdateRequest)  {
        Appointment updatedAppointment = this.appointmentService.getById(appointmentUpdateRequest.getId());
        updatedAppointment.setDateTime(updatedAppointment.getDateTime());
        return this.appointmentService.update(updatedAppointment);
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

    @GetMapping("appointments/dateTime")
    public ResponseEntity<List<Appointment>> getAppointmentsByAnimalId (@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate, @RequestParam Integer animalId) {
        return new ResponseEntity<List<Appointment>>(appointmentRepo.findByDateTimeBetweenAndAnimalId(startDate, endDate, animalId),HttpStatus.OK);
    }

    @GetMapping("appointments/dateTime/doctorId")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctorId(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate, @RequestParam Integer doctorId) {
        return new ResponseEntity<List<Appointment>>(appointmentRepo.findByDateTimeBetweenAndAnimalId(startDate,endDate,doctorId),HttpStatus.OK);
    }
}
