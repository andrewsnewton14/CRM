package project.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.crm.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	//Boolean insertCustomer(Customer customer);
	//Boolean deleteCustomer(Integer id);
	//Boolean updateCustomer(Customer customer,Integer id);
	//Customer readCustomer(Integer id);

}
