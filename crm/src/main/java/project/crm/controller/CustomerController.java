package project.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.crm.model.Customer;
import project.crm.repository.CustomerRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller

public class CustomerController {
	
	@Autowired
	CustomerRepository repository;
	
	@PostMapping("/addcustomer")
	public ModelAndView createCustomer(@ModelAttribute("customer")Customer customer) {
		System.out.println(customer.getPhoneNumber());
		repository.save(customer);
		List<Customer> customers=repository.findAll();
		ModelAndView mav=new ModelAndView("Main");
		mav.addObject("customer",customers);
		return mav;
	}
	
	@PostMapping("/delete")
	public ModelAndView deleteCustomer(@RequestParam String cid) {
		int id= Integer.parseInt(cid);
		Customer customer=repository.findById(id).get();
		repository.delete(customer);
		List<Customer> customers=repository.findAll();
		ModelAndView mav=new ModelAndView("Main");
		mav.addObject("customer",customers);
		return mav;
	}
	@GetMapping("/Main")
	public ModelAndView showCustomer(Model model) {
		//System.out.println("Customers retrieved");
		List<Customer> customers=repository.findAll();
		ModelAndView mav=new ModelAndView("Main");
		mav.addObject("customer",customers);
		return mav;
	}
	
	@PostMapping("/update")
	public ModelAndView updateCustomer(@ModelAttribute("customer")Customer customer) {
		Customer customerToUpdate=repository.findById(customer.getId()).get();
		customerToUpdate.setFirstname(customer.getFirstname());
		customerToUpdate.setLastname(customer.getLastname());
		customerToUpdate.setEmail(customer.getEmail());
		customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
		customerToUpdate.setCountry(customer.getCountry());
		repository.save(customerToUpdate);
		List<Customer> customers=repository.findAll();
		ModelAndView mav=new ModelAndView("Main");
		mav.addObject("customer",customers);
		return mav;
	}
		
}
