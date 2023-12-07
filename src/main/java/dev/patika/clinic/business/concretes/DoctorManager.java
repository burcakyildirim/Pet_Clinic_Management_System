package dev.patika.clinic.business.concretes;

import dev.patika.clinic.business.abstracts.IDoctorService;
import dev.patika.clinic.dao.DoctorRepo;
import dev.patika.clinic.entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorManager implements IDoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    //ID'ye göre doktor getirme işlemi
    @Override
    public Doctor getById(Long id) {
        return this.doctorRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " id'li doktor bulunamadı."));
    }

    //Değerlendirme Formu 12(Doktor kaydetme işlemi)
    @Override
    public Doctor save(Doctor doctor) {
        return this.doctorRepo.save(doctor);
    }

    //Sistemdeki doktorları güncelleme işlemi
    @Override
    public Doctor update(Long id,Doctor doctor) {
        Optional<Doctor> doctorFromDb = doctorRepo.findById(id);

        if(doctorFromDb.isEmpty()) {
            throw new RuntimeException(id + "Güncellemeye çalıştığınız doktorun sistemde kaydı bulunmamaktadır!");
        }
        doctor.setId(id);
        return this.doctorRepo.save(doctor);
    }

    //Sistemdeki doktorları silme işlemi
    @Override
    public void delete(Long id) {
        Doctor d = doctorRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " id'li doktor sistemde bulunamadı!"));
        this.doctorRepo.delete(this.getById(id));
    }

    //Sistemdeki tüm doktorları getiren işlem
    @Override
    public List<Doctor> findAll() {
        return this.doctorRepo.findAll();
    }
}
