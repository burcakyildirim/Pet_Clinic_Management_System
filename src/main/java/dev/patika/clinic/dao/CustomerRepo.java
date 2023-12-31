package dev.patika.clinic.dao;

import dev.patika.clinic.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {


    //Hayvan sahiplerini isme göre filtreleyen query
    List<Customer> findByName(String name);
}
