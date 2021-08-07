package project.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.crm.model.Customer;
import project.crm.repository.CustomerRepository;

@RestController
@RequestMapping(value = "/api")
public class CustomerRestController {
	
	@Autowired
	CustomerRepository repository;
	
	@GetMapping(value = "/customer/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int id) {
		Customer customer=repository.findById(id).get();
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}

}
