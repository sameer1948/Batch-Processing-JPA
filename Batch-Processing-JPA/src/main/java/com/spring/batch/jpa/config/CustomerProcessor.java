package com.spring.batch.jpa.config;

import org.springframework.batch.item.ItemProcessor;

import com.spring.batch.jpa.entity.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer>{

	@Override
	public Customer process(Customer customer) throws Exception {
		
		return customer;
	}
	
	

}
