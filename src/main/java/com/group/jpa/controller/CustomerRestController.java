package com.group.jpa.controller;

import com.group.jpa.eneity.Customer;
import com.group.jpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/customer/{age}")
    public ResponseEntity<?> getByAge(@PathVariable int age){
        List<Customer> cus = repository.findByAge(age);
        return new ResponseEntity<>(cus, HttpStatus.OK);

    }

    @PostMapping("/customer")
    public ResponseEntity<?> getUsernameAndPassword(@RequestBody Customer customer){
        Customer cus = repository.findByUsernameAndPassword(customer.getUsername(), customer.getPassword());
        return new ResponseEntity<>(cus, HttpStatus.OK);
    }

}
