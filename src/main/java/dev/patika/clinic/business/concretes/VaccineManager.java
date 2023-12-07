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

    //Aşıları ID'ye göre getirme işlemi
    @Override
    public Vaccine getById(Long id) {
        return this.vaccineRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " id'li aşı bulunamadı."));
    }

    //Değerlendirme Formu 15(Hayvanların aşılarını sisteme işleme metodu)
    @Override
        public Vaccine save(Vaccine vaccine) {
        String code = vaccine.getCode();
        Integer animalId = Math.toIntExact(vaccine.getAnimal().getId());
        LocalDate startDate = vaccine.getStartDate();

        //Değerlendirme Formu 19 (Yeni aşı kaydetme işleminde koruyuculuk bitiş tarihi kontrolü yapan işlem)
        List<Vaccine> vaccineList = vaccineRepo.findAllByAnimalIdAndCodeAndFinishDateAfter(animalId,code,startDate);

        if(!vaccineList.isEmpty()) {
            throw new RuntimeException("Aşı süresi bitmediği için yeni kayıt yapılamaz.");
        } else {
            return this.vaccineRepo.save(vaccine);
        }
    }
    //--------------------------------Kayıt İşlemi Bitiş-------------------------------------


    //Hayvanlara ait aşıları güncelleme işlemi
    @Override
    public Vaccine update(Long id,Vaccine vaccine) {
        Optional<Vaccine> vaccineFromDb = vaccineRepo.findById(id);

        if(vaccineFromDb.isEmpty()) {
            throw new RuntimeException(id + "Güncellemeye çalıştığınız aşı sistemde bulunamadı!");
        }
        vaccine.setId(id);
        return this.vaccineRepo.save(vaccine);
    }

    //Hayvanlara ait aşıları silme işlemi
    @Override
    public void delete(Long id) {
        Vaccine v = vaccineRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " id'li aşı sistemde bulunamadı."));
        this.vaccineRepo.delete(this.getById(id));
    }

    //Tüm hayvanlara ait tüm aşıları getirme işlemi
    @Override
    public List<Vaccine> findAll() {
        return this.vaccineRepo.findAll();
    }
}
