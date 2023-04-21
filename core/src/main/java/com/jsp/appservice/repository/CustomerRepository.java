package com.jsp.appservice.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jsp.appservice.entity.BankAccountEntity;
import com.jsp.appservice.entity.CustomerEntity;
import com.jsp.appservice.util.SessionFactoryUtil;

public class CustomerRepository {
	public void saveOrUpdate(CustomerEntity entity) {
		
		SessionFactory sessionfactory = SessionFactoryUtil.getSessionfactory();
		Session session = sessionfactory.openSession();
		
		Transaction transaction= session.beginTransaction();
		session.merge(entity);
		transaction.commit();
		
		//System.out.println(obj);
	}
	
	public void deleteByName(String name) {
		SessionFactory sessionfactory = SessionFactoryUtil.getSessionfactory();
		Session session = sessionfactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		session.delete("CustomerEntity.java", name);
		transaction.commit();
	}
}
