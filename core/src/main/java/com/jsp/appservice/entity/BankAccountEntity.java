package com.jsp.appservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_account_info")
public class BankAccountEntity implements Serializable{
	
	@Id
	@Column(name ="id")
	private int id;
	
	@Column(name = "name", nullable = false) //default value for nullable is true and default value for unique false
	private String name;
	
	@Column(name="account_Number", unique = true)
	private String accountNumber;
	
	public BankAccountEntity() {
		// TODO Auto-generated constructor stub
	}

	public BankAccountEntity(int id, String name, String accountNumber) {
		super();
		this.id = id;
		this.name = name;
		this.accountNumber = accountNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	

}
