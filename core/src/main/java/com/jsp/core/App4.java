package com.jsp.core;

import java.util.ArrayList;
import java.util.List;

import com.jsp.appservice.entity.BankAccountEntity;
import com.jsp.appservice.entity.CustomerEntity;
import com.jsp.appservice.repository.CustomerRepository;

public class App4 {

	public static void main(String[] args) {
				
//		List<BankAccountEntity> list = new ArrayList<BankAccountEntity>();
//		list.add(new BankAccountEntity(3, "YES BANK", "54698723"));
//		list.add(new BankAccountEntity(4, "CENTRAL BANK", "21457896"));
//	
		CustomerEntity entity = new CustomerEntity();
//		entity.setName("KRISHNA");
//		entity.setAddress("Banglore");
//		entity.setAccounts(list);
//		
		CustomerRepository repo = new CustomerRepository();
		//repo.saveOrUpdate(entity);
		
		repo.deleteByName("Pawana Sutha");
	}

}
