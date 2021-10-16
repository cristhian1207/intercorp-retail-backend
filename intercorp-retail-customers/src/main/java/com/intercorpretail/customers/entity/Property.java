package com.intercorpretail.customers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROPERTIES")
public class Property {

	@Id
	@Column(name="PROPERTIES_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long propertiesId;

	@Column(name="NAME", columnDefinition="VARCHAR(100)", nullable=false)
	private String name;

	@Column(name="VALUE", columnDefinition="VARCHAR(100)", nullable=false)
	private String value;

	public Property() { }

	public Property(Long propertiesId, String name, String value) {
		super();
		this.propertiesId = propertiesId;
		this.name = name;
		this.value = value;
	}

	public Long getPropertiesId() {
		return propertiesId;
	}

	public void setPropertiesId(Long propertiesId) {
		this.propertiesId = propertiesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Property [propertiesId=" + propertiesId + ", name=" + name + ", value=" + value + "]";
	}
	
}
