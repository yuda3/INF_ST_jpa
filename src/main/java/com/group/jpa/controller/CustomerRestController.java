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
//
//    @GetMapping("/customer/{age}")
//    public ResponseEntity<?> getByAge(@PathVariable int age){
//        List<Customer> cus = repository.findByAge(age);
//        return new ResponseEntity<>(cus, HttpStatus.OK);
//    }

    @PostMapping("/customer")
    public ResponseEntity<?> getUsernameAndPassword(@RequestBody Customer customer){
        Customer cus = repository.findByUsernameAndPassword(customer.getUsername(), customer.getPassword());
        return new ResponseEntity<>(cus, HttpStatus.OK);
    }

//    @GetMapping("/customer/user/{username}")
//    public ResponseEntity<?> getUsernameIs(@PathVariable String username){
//        Customer cus = repository.findByUsernameIs(username);
//        return new ResponseEntity<>(cus, HttpStatus.OK);
//    }

    @GetMapping("/customer/user/{age}")
    public ResponseEntity<?> findByAgerGreaterThanEqual(@PathVariable int age) {
        List<Customer> cus = repository.findByAgeGreaterThanEqual(age);
        return new ResponseEntity<>(cus, HttpStatus.OK);
    }

    @GetMapping("/customer/{rating}")
    public ResponseEntity<?> getRating(@PathVariable String rating) {
        List<Customer> clist = repository.getRating(rating);
        return new ResponseEntity<>(clist, HttpStatus.OK);
    }
}
