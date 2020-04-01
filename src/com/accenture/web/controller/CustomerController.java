package com.accenture.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.bean.Customer;
import com.accenture.dao.CustomerDAOWrapper;


@RestController
public class CustomerController {
	
	@Autowired
	CustomerDAOWrapper customerDAO;
	
	@RequestMapping(value = "cust/controller/getDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getCustomerDetails() {
		List<Customer> listEmployee = new ArrayList<Customer>(customerDAO.findAll());
		
		return new ResponseEntity<List<Customer>>(listEmployee,HttpStatus.OK);
	}
	
	@RequestMapping(value = "cust/controller/getDetailsById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomerDetailByCustomerId(@PathVariable("id") int myId) {
		Customer customer = customerDAO.findOne(myId);

		if (customer != null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} else {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/cust/controller/addEmp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody Customer customer) {
		int count=customerDAO.saveCustomer(customer);
		return new ResponseEntity<String>("Employee added successfully with id:" + count,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/cust/controller/updateEmp", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateCustomer(@RequestBody  Customer customer) {
		if (customerDAO.findOne(customer.getCustomer_id()) == null) {
			Customer customer2 = null;
			return new ResponseEntity<Customer>(customer2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Customer updated = customerDAO.updateCustomer(customer);
		return new ResponseEntity<Customer>(updated, HttpStatus.OK);
	}

	@RequestMapping(value = "/cust/controller/deleteEmp/{id}", method = RequestMethod.DELETE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> deleteEmployee(@PathVariable("id") int myId) {
		Customer customer2=customerDAO.findOne(myId);
		if (customerDAO.findOne(myId) == null) {
			return new ResponseEntity<Customer>(customer2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		customerDAO.delete(myId);
		return new ResponseEntity<Customer>(customer2, HttpStatus.OK);
	}

}
