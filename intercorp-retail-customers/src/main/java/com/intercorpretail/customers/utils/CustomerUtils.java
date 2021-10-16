package com.intercorpretail.customers.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.intercorpretail.customers.entity.Customer;
import com.intercorpretail.customers.entity.Property;
import com.intercorpretail.customers.service.IPropertyService;

@Service
@Scope("singleton")
public class CustomerUtils {

	private final static String PROPERTY_CUSTOMERS_LIFE_EXPECTANCY = "customers.life.expectancy";

	@Autowired
	private IPropertyService propertyService;
	
	public List<Customer> customersWithDeathDate(List<Customer> customers) {
		Property property = this.propertyService.findPropertyByName(PROPERTY_CUSTOMERS_LIFE_EXPECTANCY);
		String lifeExpectancyStr = property.getValue();
		int lifeExpectancy = Integer.parseInt(lifeExpectancyStr);

		Date deathDate;
		for (Customer customer : customers) {
			deathDate = this.calcDeathDate(customer.getBirthday(), lifeExpectancy);
			customer.setDeathDate(deathDate);
		}
		return customers;
	}

	private Date calcDeathDate(Date birthday, int lifeExpectancy) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthday);
		calendar.add(Calendar.YEAR, lifeExpectancy);
		return calendar.getTime();
	}

}
