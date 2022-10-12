package org.cap.demo.controller;

import java.util.List;

import org.cap.demo.model.Customer;
import org.cap.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class CustomerRestController {
	
	@Autowired
	private ICustomerService customerService;
	
	//@PatchMapping("/customers/{custId}/{emailId}")
	@PatchMapping("/customers")
	public ResponseEntity<Customer> updateCustomerEmails(@RequestBody Customer customer){
			//@PathVariable("custId")Integer custId,@PathVariable("emailId")String emailId) {
		Customer customer2= customerService.updateCustomerEmails(customer.getCustomerId(),customer.getEmailId());
		if(customer2==null)
			return new ResponseEntity("Sorry!Update Error, Customer Id Not exists!",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Customer>(customer2, HttpStatus.OK);
	}
	
	
	@PutMapping("/customers")
	public ResponseEntity<Customer>  updateCustomer(@RequestBody Customer customer) {
		Customer customer2=customerService.updateCustomer(customer);
		if(customer2==null)
			return new ResponseEntity("Sorry!Update Error, Customer Id Not exists!",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Customer>(customer2, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/customers/{custId}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("custId")Integer custId){
		List<Customer> customers= customerService.deleteCustomer(custId);
		
		if(customers==null || customers.isEmpty())
			return new ResponseEntity("Sorry! Deletion Error, No CustId Exists to Delete!",
					HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	
	@PostMapping("/customers")
	public ResponseEntity<List<Customer>>  createCustomer(@RequestBody Customer customer) {
		List<Customer> customers= customerService.addCustomer(customer);
		if(customers==null || customers.isEmpty())
			return new ResponseEntity("Sorry! Insertion Error!",HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		
	}
	
	@GetMapping("/customers/{custId}")
	public ResponseEntity<Customer> findCustomers(@PathVariable("custId")Integer custId){
		
		Customer customer= customerService.findCustomer(custId);
		if(customer==null)
			return new ResponseEntity("Sorry! No Customer ID Exists!",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	@GetMapping("/greetings")
	public ResponseEntity<String> getGreetMsg(){
		
		
		return new ResponseEntity<String>("</h1>Hello! I completed RolleOut!<h1>", HttpStatus.OK);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> getGreetMsg(){
		
		
		return new ResponseEntity<String>("</h1>Hello All! Verion2 is Ready!!!!!!<h1>", HttpStatus.OK);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		
		List<Customer> customers= customerService.getAllCustomers();
		if(customers==null || customers.isEmpty())
			return new ResponseEntity("Sorry! No Customer Available!",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
}
