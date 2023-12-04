package dev.patika.clinic.api;

import dev.patika.clinic.business.abstracts.ICustomerService;
import dev.patika.clinic.dao.CustomerRepo;
import dev.patika.clinic.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    private final ICustomerService customerService;
    @Autowired
    private CustomerRepo customerRepo;
    private Object ResponseEntity;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findAll() {
        return  this.customerService.findAll();
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer) {
        return this.customerService.save(customer);
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public Customer update(@RequestBody Customer customer) {
        return this.customerService.update(customer);
    }

    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.customerService.delete(id);
    }

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getById(@PathVariable("id") Long id) {
        return this.customerService.getById(id);
    }

    @GetMapping("/customers/name")
    public ResponseEntity<List<Customer>> getCustomerByName(@RequestParam String name) {
        return new ResponseEntity<List<Customer>>(customerRepo.findByName(name),HttpStatus.OK);
    }
}