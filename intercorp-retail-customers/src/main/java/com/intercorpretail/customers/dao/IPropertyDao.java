package com.intercorpretail.customers.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intercorpretail.customers.entity.Property;

public interface IPropertyDao extends JpaRepository<Property, Long> {

	public Property findPropertyByName(String name);

}
