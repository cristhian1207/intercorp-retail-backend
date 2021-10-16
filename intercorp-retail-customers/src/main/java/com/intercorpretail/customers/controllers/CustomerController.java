package com.intercorpretail.customers.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intercorpretail.customers.entity.Customer;
import com.intercorpretail.customers.service.ICustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins= {"http://localhost:3000"})
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@PostMapping("/creacliente")
	public ResponseEntity<Customer> save(@RequestBody Customer customer) {
		Customer customerSaved = this.customerService.save(customer); 
		return new ResponseEntity<>(customerSaved, HttpStatus.CREATED);
	}

	@GetMapping("/kpideclientes")
	public Map<String, Object> kpi() {
		return this.customerService.kpi();
	}

	@GetMapping("/listclientes")
	public List<Customer> customers() {
		return this.customerService.findAll();
	}
}
