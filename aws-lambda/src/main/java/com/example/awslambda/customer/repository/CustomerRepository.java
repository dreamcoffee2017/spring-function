package com.example.awslambda.customer.repository;

import com.example.awslambda.customer.entity.Customer;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface CustomerRepository extends CrudRepository<Customer, String> {

}
