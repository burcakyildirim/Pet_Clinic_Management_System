package dev.patika.clinic.dao;

import dev.patika.clinic.entities.Vaccine;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine, Long> {

    //Sadece bir hayvanın tüm aşı kayıtlarını getirmek için kullanılan query
    List<Vaccine> findByAnimalId(Integer animalId);

    // Aşı koruyuculuk bitiş tarihi yaklaşan hayvanları filtrelemek için kullanılan query
    List<Vaccine> findByFinishDateBetween(LocalDate startDate, LocalDate endDate);

    //Yeni aşı kaydetme işleminde koruyuculuk bitiş tarihi kontrolü yapmak için kullanılan query
    List<Vaccine> findAllByAnimalIdAndCodeAndFinishDateAfter(Integer animalId,String code,LocalDate startDate);

}