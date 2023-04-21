package com.jsp.core;

import com.jsp.appservice.entity.ApplicationEntity;
import com.jsp.appservice.repository.ApplicationRepositiory1;

public class App {

	public static void main(String[] args) {
		ApplicationEntity entity = new ApplicationEntity();
		//entity.setAltkey(456);
		entity.setApplicationName("Business App");
		entity.setApplicationType("Business");
		entity.setUrl("org.business.com");
		entity.setUserName("Maadhav");
		entity.setPassword("5663");
		
		ApplicationRepositiory1 repo = new ApplicationRepositiory1();
		
		//ApplicationEntity applicationEntity2 = repo.getById(124);
		
		// Update
		repo.saveOrUpdate(entity);
		//repo.update(applicationEntity2);
		
		// Delete 
		//repo.deleteRows(457);
		
		
	}

	
}