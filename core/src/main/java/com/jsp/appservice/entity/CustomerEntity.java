package com.jsp.appservice.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer_info")
public class CustomerEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="address")
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_account_id")
	List<BankAccountEntity> accounts;
	
	public CustomerEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerEntity(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<BankAccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccountEntity> accounts) {
		this.accounts = accounts;
	}

}
