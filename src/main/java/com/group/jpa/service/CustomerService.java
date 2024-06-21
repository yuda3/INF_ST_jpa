package com.group.jpa.service;

import com.group.jpa.eneity.Customer;
import com.group.jpa.eneity.Review;
import com.group.jpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @Transactional
    public List<Review> getReviewsByCustomerId(Long id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return customer.getReviews();

    }
}
