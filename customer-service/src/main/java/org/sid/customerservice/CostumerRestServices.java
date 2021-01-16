package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CostumerRestServices {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/listCustomer")
    public List<Customer> listProducts() {
        return customerRepository.findAll();
    }
    @GetMapping(value = "/listCustomer/{id}")
    public Customer listProducts(@PathVariable(name = "id")long id) {
        return customerRepository.findById(id).get();
    }
    @PutMapping (value = "/listCustomer/{id}")
    public Customer update(@PathVariable(name = "id")long id ,@RequestBody  Customer p) {
        p.setId(id);
        return customerRepository.save(p);
    }
    @PostMapping (value = "/listCustomer")
    public Customer save(@RequestBody  Customer p) {

        return customerRepository.save(p);
    }
    @DeleteMapping(value = "/listCustomer/{id}")
    public void delete(@PathVariable(name = "id")long id) {

        customerRepository.deleteById(id);
    }
}
