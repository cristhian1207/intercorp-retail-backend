package com.intercorpretail.customers.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="CUSTOMERS")
public class Customer {

	@Id
	@Column(name="CUSTOMERS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long customerId;

	@Column(name="NAME", columnDefinition="VARCHAR(30)", nullable=false)
	private String name;

	@Column(name="LASTNAME", columnDefinition="VARCHAR(30)", nullable=false)
	private String lastname;

	@Column(name="BIRTHDAY", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;

	@Formula("f_current_year_diff(BIRTHDAY)")
	private Integer age;

	@Transient
	private Date deathDate;

	public Customer() { }

	public Customer(Long customerId, String name, String lastname, Date birthday, Integer age, Date deathDate) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.lastname = lastname;
		this.birthday = birthday;
		this.age = age;
		this.deathDate = deathDate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", lastname=" + lastname + ", birthday="
				+ birthday + ", age=" + age + ", deathDate=" + deathDate + "]";
	};

}
