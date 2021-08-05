package org.cap.demo.service;

import java.util.List;

import org.cap.demo.dao.ICustomerDao;
import org.cap.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService{

	
	@Autowired
	private ICustomerDao customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		
		return customerRepository.getAllCustomers();
	}

	@Override
	public Customer findCustomer(Integer custId) {
		
		return customerRepository.findCustomer(custId);
	}

	@Override
	public List<Customer> addCustomer(Customer customer) {
		
		return customerRepository.addCustomer(customer);
	}

	@Override
	public List<Customer> deleteCustomer(Integer custId) {
		// TODO Auto-generated method stub
		return customerRepository.deleteCustomer(custId);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.updateCustomer(customer);
	}

	@Override
	public Customer updateCustomerEmails(Integer custId, String emailId) {
		// TODO Auto-generated method stub
		return customerRepository.updateCustomerEmails(custId,emailId);
	}

}
