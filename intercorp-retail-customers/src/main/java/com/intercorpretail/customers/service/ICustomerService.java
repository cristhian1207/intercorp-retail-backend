package com.intercorpretail.customers.service;

import java.util.List;
import java.util.Map;

import com.intercorpretail.customers.entity.Customer;

public interface ICustomerService  {

	public Customer save(Customer customer);
	public Map<String, Object> kpi();
	public List<Customer> findAll();

}
