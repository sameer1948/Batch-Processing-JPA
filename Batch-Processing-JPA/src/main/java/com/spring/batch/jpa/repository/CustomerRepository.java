package com.spring.batch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.batch.jpa.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
