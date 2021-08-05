package org.cap.demo.service;

import java.util.List;

import org.cap.demo.model.Customer;

public interface ICustomerService {
	
	public List<Customer> getAllCustomers();

	public Customer findCustomer(Integer custId);

	public List<Customer> addCustomer(Customer customer);

	public List<Customer> deleteCustomer(Integer custId);

	public Customer updateCustomer(Customer customer);

	public Customer updateCustomerEmails(Integer custId, String emailId);

}
