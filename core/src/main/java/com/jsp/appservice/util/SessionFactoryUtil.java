package com.jsp.appservice.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsp.appservice.entity.ApplicationEntity;
import com.jsp.appservice.entity.BankAccountEntity;
import com.jsp.appservice.entity.CustomerEntity;
import com.jsp.appservice.entity.RegistrationDetails;
import com.jsp.appservice.entity.VehicleEntity;

public class SessionFactoryUtil {
	
	private static SessionFactory sessionFactory = null;
	
	// Approach 1: Creating only one sessionFactory object
	// As static blocks are executed only once during class loading.
	
	static {
		Configuration cfg = new Configuration(); // It creates a path or road between eclipse and database.
		cfg.setProperties(MysqlConnectionPropertiesUtil.getConnectionProperties());
		cfg.addAnnotatedClass(ApplicationEntity.class);
		
		cfg.addAnnotatedClass(VehicleEntity.class);
		cfg.addAnnotatedClass(RegistrationDetails.class);
		cfg.addAnnotatedClass(CustomerEntity.class);
		cfg.addAnnotatedClass(BankAccountEntity.class);
		
		sessionFactory = cfg.buildSessionFactory();
	}
	
	// Used to return sessionFactory object 
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}

}
