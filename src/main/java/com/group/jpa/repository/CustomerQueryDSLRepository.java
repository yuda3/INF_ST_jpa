package com.group.jpa.repository;

import com.group.jpa.eneity.Customer;
import com.group.jpa.eneity.QCustomer;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerQueryDSLRepository {

    private final JPAQueryFactory queryFactory;

    public Customer getUsernameAndPassword(String username, String password){
        QCustomer customer = QCustomer.customer;
        System.out.println(customer);
        return queryFactory.selectFrom(customer)
                .where(customer.username.eq(username)
                .and(customer.password.eq(password)))
                .fetchOne();
    }

    public List<Customer> getRating(String rating){
        QCustomer customer = QCustomer.customer;
        return queryFactory.selectFrom(customer)
                .where(customer.rating.eq(rating))
                .fetch();
    }
}
