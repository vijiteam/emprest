package org.cap.demo.model;

import java.util.ArrayList;
import java.util.List;


public class Customer {
	
	private int customerId;
	private String customerName;
	private String emailId;
	private String mobileNo;
	
	
	private List<Account> accounts=new ArrayList<Account>();

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Customer(int customerId, String customerName, String emailId, String mobileNo, List<Account> accounts) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.accounts = accounts;
	}

	public Customer() {
		super();
	}
	
	

	public Customer(int customerId, String emailId) {
		super();
		this.customerId = customerId;
		this.emailId = emailId;
	}

	public Customer(int customerId, String customerName, String emailId, String mobileNo) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", emailId=" + emailId
				+ ", mobileNo=" + mobileNo + ", accounts=" + accounts + "]";
	}
	
	
}
 