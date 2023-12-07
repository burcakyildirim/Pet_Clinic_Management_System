package dev.patika.clinic.business.concretes;

import dev.patika.clinic.business.abstracts.IAvailableDateService;
import dev.patika.clinic.dao.AvailableDateRepo;
import dev.patika.clinic.entities.AvailableDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvailableDateManager implements IAvailableDateService {

    @Autowired
    private AvailableDateRepo availableDateRepo;

    //ID'ye göre sistemdeki doktorların müsait gününü getiren işlem
    @Override
    public AvailableDate getById(Long id) {
        return this.availableDateRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " id'li doktorun müsait gübü bulunamadı."));
    }

    //Değerlendirme Formu 13(Doktorun müsait gününü sisteme işleme metodu)
    @Override
    public AvailableDate save(AvailableDate availableDate) {
        return this.availableDateRepo.save(availableDate);
    }

    //Sistemdeki müsait günleri güncelleme işlemi
    @Override
    public AvailableDate update(Long id, AvailableDate availableDate) {
        Optional<AvailableDate> availableDateFromDb = availableDateRepo.findById(id);

        if(availableDateFromDb.isEmpty()) {
            throw new RuntimeException(id +"Güncellemeye çalıştığınız doktorun müsait günü sistemde bulunamadı!");
        }
        availableDate.setId(id);
        return this.availableDateRepo.save(availableDate);
    }

    //Sistemdeki müsait günleri silme işlemi
    @Override
    public void delete(Long id) {
        AvailableDate av = availableDateRepo.findById(id).orElseThrow(() ->
                new RuntimeException(id + " id'li doktora ait uygun gün sistemde bulunamadı."));
        this.availableDateRepo.delete(this.getById(id));
    }

    //Sistemdeki doktorların tüm müsait günlerini getiren işlem
    @Override
    public List<AvailableDate> findAll() {
        return this.availableDateRepo.findAll();
    }
}
