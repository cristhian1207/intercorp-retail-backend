package com.intercorpretail.customers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intercorpretail.customers.constants.CustomerQueries;
import com.intercorpretail.customers.entity.Customer;

public interface ICustomerDao extends JpaRepository<Customer, Long> {

	@Query(value=CustomerQueries.SQL_SUM_AGE, nativeQuery = true)
	public int sumAge();

	@Query(value=CustomerQueries.SQL_USP_STD, nativeQuery = true)
	public double stdAge();
}
