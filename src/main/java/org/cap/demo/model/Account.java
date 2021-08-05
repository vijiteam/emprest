package org.cap.demo.model;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnore;


public class Account {
	
	private int accountId;
	private String accountType;
	private LocalDate openingDate;
	private double balance;
	
	@JsonIgnore
	private Customer customer;
	
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public LocalDate getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account(int accountId, String accountType, LocalDate openingDate, double balance) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.openingDate = openingDate;
		this.balance = balance;
	}
	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType=" + accountType + ", openingDate=" + openingDate
				+ ", balance=" + balance + "]";
	}
	
	

}
