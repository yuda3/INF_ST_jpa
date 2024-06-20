package com.group.jpa.repository;

import com.group.jpa.controller.CustomerRestController;
import com.group.jpa.eneity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
     List<Customer> findByAge(int age);

     Customer findByUsernameAndPassword(String username, String password);
}
