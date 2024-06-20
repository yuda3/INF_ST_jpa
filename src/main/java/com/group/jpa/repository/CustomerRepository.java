package com.group.jpa.repository;

import com.group.jpa.eneity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
     List<Customer> findByAge(int age);

     Customer findByUsernameAndPassword(String username, String password);

     Customer findByUsernameIs(String username);

     List<Customer> findByAgeGreaterThanEqual(int age);

     //@Query("SELECT cus FROM Customer cus WHERE cus.rating =:rating")
     @Query(value = "SELECT * FROM Customer  WHERE rating =?1", nativeQuery = true)
     List<Customer> getRating(@Param("rating") String rating);



}
