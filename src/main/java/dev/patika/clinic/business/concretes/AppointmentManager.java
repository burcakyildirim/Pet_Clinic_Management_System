package dev.patika.clinic.business.concretes;

import dev.patika.clinic.api.AppointmentController;
import dev.patika.clinic.business.abstracts.IAppointmentService;
import dev.patika.clinic.dao.AppointmentRepo;
import dev.patika.clinic.dao.AvailableDateRepo;
import dev.patika.clinic.dao.DoctorRepo;
import dev.patika.clinic.entities.Animal;
import dev.patika.clinic.entities.Appointment;
import dev.patika.clinic.entities.AvailableDate;
import dev.patika.clinic.entities.Doctor;
import org.apache.tomcat.util.descriptor.web.ApplicationParameter;
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
    private AvailableDateRepo availableDateRepo;

    //Sistemdeki randevuları ID'ye göre getirme işlemi
    @Override
    public Appointment getById(Long id) {
        return this.appointmentRepo.findById(id).orElseThrow(()->
        new RuntimeException(id + " id'li randevu bulunamadı."));
    }

    //Değerlendirme Formu 14(Randevu kaydetme işlemi)
    @Override
    public Appointment save(Appointment appointment) {
        LocalDateTime dateTime = appointment.getDateTime();
        Integer doctorId = Math.toIntExact(appointment.getDoctor().getId());

        //Değerlendirme Formu 22 (Önce müsait gün kontrolü sonra varsa boş saatin kontrolünü yapan işlem)
        List<AvailableDate> availableDateList= availableDateRepo.findByDoctorIdAndDate(doctorId, dateTime.toLocalDate());
        if(availableDateList != null && isAvailableDateExistOnDate(doctorId, dateTime.toLocalDate())) {
            throw new RuntimeException("Doktorun bugün de müsait günü yoktur.");
        }
        if(availableDateList != null && isAppointmentExistOnDate(doctorId, dateTime)) {
            throw new RuntimeException("Girilen saatte başka bir randevu mevcuttur.");
        } else {
            return this.appointmentRepo.save(appointment);
        }
    }

    //Doktorun müsait gününde o saatte başka bir randevusu var mı kontrolü
    private boolean isAppointmentExistOnDate(Integer doctorId, LocalDateTime dateTime) {
        return appointmentRepo.existsByDoctorIdAndDateTime(doctorId, dateTime);
    }

    //Doktorun müsait günü var mı  kontrolü
    private boolean isAvailableDateExistOnDate(Integer doctorId, LocalDate date) {
        return !availableDateRepo.existsByDoctorIdAndDate(doctorId,date);
    }
//------------------------------------Randevu kaydetme işlemi bitiş --------------------------


    //Randevuları güncelleme işlemi
    @Override
    public Appointment update(Long id,Appointment appointment) {
        Optional<Appointment> appointmentFromDb = appointmentRepo.findById(id);

        if(appointmentFromDb.isEmpty()) {
            throw new RuntimeException(id + "Güncellemeye çalıştığınız randevu sistemde bulunamadı!");
        }
        appointment.setId(id);
        return this.appointmentRepo.save(appointment);
    }

    //Randevuları silme işlemi
    @Override
    public void delete(Long id) {
        Appointment ap = appointmentRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " id'li randevu sistemde bulunamadı!"));
        this.appointmentRepo.delete(this.getById(id));
    }

    //Sistemdeki randevuların hepsini getiren işlem
    @Override
    public List<Appointment> findAll() {
        return this.appointmentRepo.findAll();
    }
}
