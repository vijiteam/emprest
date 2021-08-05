package org.cap.demo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;

import org.cap.demo.model.Account;
import org.cap.demo.model.Customer;
import org.springframework.stereotype.Repository;
@Repository("customerRepository")
public class CustomerRepository implements ICustomerDao{

	private static AtomicInteger customerId=new AtomicInteger(1000);
	private static AtomicInteger accountId=new AtomicInteger(13213213);
	
	private static List<Customer> dummyDb=init_DummyDB();
	
	private static List<Customer> init_DummyDB(){
		List<Customer>  customers=new ArrayList<Customer>();
		
			Customer customer=new Customer(customerId.getAndIncrement(), "tom", "tom@gmail.com", "3124324");
				Account account=new Account(accountId.getAndIncrement(), "Savings", LocalDate.now(), 3123.00);
				Account account1=new Account(accountId.getAndIncrement(), "Current", LocalDate.of(2000, 12, 23), 45000.00);
			customer.getAccounts().add(account);	
			customer.getAccounts().add(account1);
			
			
			Customer customer1=new Customer(customerId.getAndIncrement(), "Jack", "jack@gmail.com", "32432432");
			Account account2=new Account(accountId.getAndIncrement(), "RD", LocalDate.now(), 6700.00);
			Account account3=new Account(accountId.getAndIncrement(), "Current", LocalDate.of(2000, 12, 23), 89000.00);
		customer1.getAccounts().add(account2);	
		customer1.getAccounts().add(account3);
		
		customers.add(customer);
		customers.add(customer1);
		return customers;
	}
	
	
	@Override
	public List<Customer> getAllCustomers() {
		
		return dummyDb;
	}


	@Override
	public Customer findCustomer(Integer custId) {
		for(Customer customer:dummyDb) {
			if(custId==customer.getCustomerId()) {
				return customer;
			}
		}
		return null;
	}


	@Override
	public List<Customer> addCustomer(Customer customer) {
		dummyDb.add(customer);
		return dummyDb;
	}


	@Override
	public List<Customer> deleteCustomer(Integer custId) {
		boolean flag=false;
		Iterator<Customer> iterator= dummyDb.iterator();
		while(iterator.hasNext()) {
			Customer customer= iterator.next();
			if(customer.getCustomerId()==custId)
			{
				flag=true;
				iterator.remove();
				break;
			}
		}
		
		if(flag)
			return dummyDb;
		else
			return null;
	}


	@Override
	public Customer updateCustomer(Customer customer2) {
		
		boolean flag=false;
		ListIterator<Customer> iterator= dummyDb.listIterator();
		while(iterator.hasNext()) {
			Customer customer= iterator.next();
			if(customer.getCustomerId()==customer2.getCustomerId())
			{
				flag=true;
				iterator.set(customer2);
				break;
			}
		}
		
		if(flag)
			return customer2;
		else
			return null;
		
	}


	@Override
	public Customer updateCustomerEmails(Integer custId, String emailId) {
		boolean flag=false;
		Customer customer=null;
		ListIterator<Customer> iterator= dummyDb.listIterator();
		while(iterator.hasNext()) {
			customer= iterator.next();
			if(customer.getCustomerId()==custId)
			{
				flag=true;
				customer.setEmailId(emailId);
				iterator.set(customer);
				break;
			}
		}
		
		if(flag)
			return customer;
		else
			return null;
		
	}

}
