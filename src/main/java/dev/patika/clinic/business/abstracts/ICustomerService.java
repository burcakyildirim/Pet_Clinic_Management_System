package dev.patika.clinic.business.abstracts;

import dev.patika.clinic.entities.Animal;
import dev.patika.clinic.entities.Customer;

import java.util.List;

public interface ICustomerService {

    Customer getById(Long id);

    Customer save(Customer customer);

    Customer update(Long id, Customer customer);

    void delete(Long id);

    List<Customer> findAll();
}
