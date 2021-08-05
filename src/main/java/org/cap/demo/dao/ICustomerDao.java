package org.cap.demo.dao;

import java.util.List;

import org.cap.demo.model.Customer;

public interface ICustomerDao {
	public List<Customer> getAllCustomers();

	public Customer findCustomer(Integer custId);

	public List<Customer> addCustomer(Customer customer);

	public List<Customer> deleteCustomer(Integer custId);

	public Customer updateCustomer(Customer customer);

	public Customer updateCustomerEmails(Integer custId, String emailId);
}
