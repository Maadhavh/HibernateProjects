package com.jsp.appservice.repository;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.appservice.dto.ApplicationDto1;
import com.jsp.appservice.entity.ApplicationEntity;
import com.jsp.appservice.util.MysqlConnectionPropertiesUtil;
import com.jsp.appservice.util.SessionFactoryUtil;

public class ApplicationRepositiory1 {	
	public void saveOrUpdate(ApplicationEntity applicationEntity) {
		Object obj;
		
		SessionFactory sessionfactory = SessionFactoryUtil.getSessionfactory();
		Session session = sessionfactory.openSession();
		
		Transaction transaction= session.beginTransaction();
		obj = session.merge(applicationEntity);
		transaction.commit();
		
		//System.out.println(obj);
	}
	
	public ApplicationEntity getById(long id) {
		
		SessionFactory sessionfactory = SessionFactoryUtil.getSessionfactory();
		Session session=sessionfactory.openSession();
		
		return session.get(ApplicationEntity.class, id);
		}
	
	public void update(ApplicationDto1 dto) {		
		//Here open database and get the row which has the altkey value and close the session.
		ApplicationEntity applicationEntity = getById(dto.getAltKey());

		
		// If we dont check this condition it will give null exception when passed key is not present inside a table.
		if(applicationEntity != null) {
			System.out.println(dto.getAltKey()+ " key is present and will be updating values for this row");
			applicationEntity.setUserName(dto.getUserName());
			applicationEntity.setPassword(dto.getPassword());
			
			//Here again update values which has altkey value and updating it.
			saveOrUpdate(applicationEntity);			
		}
		else {
			
			System.out.println(dto.getAltKey()+" primary key not present. Therefore creating new row and adding values");
			ApplicationEntity applicationEntity2 = new ApplicationEntity();
			//applicationEntity2.setAltkey(dto.getAltKey());
			applicationEntity2.setApplicationName("Game App");
			applicationEntity2.setUserName(dto.getUserName());
			applicationEntity2.setPassword(dto.getPassword());
			
			//Here again update values which has altkey value and updating it.
			saveOrUpdate(applicationEntity2);		
		}
		
	}
	
	public void deleteRows(int id) {
		ApplicationEntity applicationEntity = getById(id);
		
		SessionFactory sessionfactory = SessionFactoryUtil.getSessionfactory();
		Session session=sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(applicationEntity);
		transaction.commit();
	}
	
	public void getByUserName(String userName) {
		
	}
}
