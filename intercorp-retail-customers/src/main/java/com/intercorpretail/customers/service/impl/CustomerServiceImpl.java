package com.intercorpretail.customers.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intercorpretail.customers.dao.ICustomerDao;
import com.intercorpretail.customers.entity.Customer;
import com.intercorpretail.customers.service.ICustomerService;
import com.intercorpretail.customers.utils.CustomerUtils;

@Service
public class CustomerServiceImpl implements ICustomerService {

	private static final String KEY_EDAD_PROMEDIO = "edad_promedio";
	private static final String KEY_DESVIACION_ESTANDAR = "desviacion_estandar";
	
	@Autowired
	private ICustomerDao customerDao;

	@Autowired
	private CustomerUtils customerUtils;

	@Override
	public Customer save(Customer customer) {
		return this.customerDao.save(customer);
	}

	@Override
	@Transactional(readOnly=true)
	public Map<String, Object> kpi() {
		Long customersCount = this.customerDao.count();
		int sumAges = this.customerDao.sumAge();

		double stdAge = this.customerDao.stdAge();
		double ageAvg = (double)sumAges / customersCount;

		Map<String, Object> kpi = new HashMap<>();
		kpi.put(KEY_EDAD_PROMEDIO, ageAvg);
		kpi.put(KEY_DESVIACION_ESTANDAR, stdAge);
		return kpi;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Customer> findAll() {
		List<Customer> customers = this.customerDao.findAll();
		customers = this.customerUtils.customersWithDeathDate(customers);
		return customers;
	}

}
