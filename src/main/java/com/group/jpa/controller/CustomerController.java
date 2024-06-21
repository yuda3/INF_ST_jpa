package com.group.jpa.controller;


import com.group.jpa.eneity.Customer;
import com.group.jpa.eneity.Review;
import com.group.jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public String showCustomerList(Model model){
        List<Customer> allCustomers = customerService.getAllCustomers();
        model.addAttribute("customers", allCustomers);
        return "customerList";
    }

    @GetMapping("/customer/reviews")
    public String getReviews(@RequestParam("id") Long id, Model model){
        List<Review> reviews = customerService.getReviewsByCustomerId(id);
        model.addAttribute("reviews", reviews);
        return "reviewList";
    }
}
