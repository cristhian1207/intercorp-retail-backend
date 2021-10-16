package com.intercorpretail.customers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intercorpretail.customers.dao.IPropertyDao;
import com.intercorpretail.customers.entity.Property;
import com.intercorpretail.customers.service.IPropertyService;

@Service
public class PropertyServiceImpl implements IPropertyService {

	@Autowired
	private IPropertyDao propertyDao;

	@Override
	public Property findPropertyByName(String name) {
		return this.propertyDao.findPropertyByName(name);
	}

}
