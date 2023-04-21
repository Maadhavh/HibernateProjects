package com.jsp.appservice.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.appservice.dto.ApplicationDto1;
import com.jsp.appservice.entity.ApplicationEntity;
import com.jsp.appservice.util.MysqlConnectionPropertiesUtil;
import com.jsp.appservice.util.SessionFactoryUtil;

public class ApplicationRepository {
	//THIS CLASS WILL HOLD ONLY THE LOGIC RELATED TO DATABASE CONNECTION.
	
		public void saveApplicationDetails(ApplicationEntity applicationEntity) {

			Configuration cfg = new Configuration(); // It creates a path or road between eclipse and database.
			cfg.setProperties(MysqlConnectionPropertiesUtil.getConnectionProperties());
			cfg.addAnnotatedClass(ApplicationEntity.class);	
			
			SessionFactory sessionFactory = cfg.buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Transaction transaction= session.beginTransaction();
			session.save(applicationEntity);
			transaction.commit();
		}
		
		public ApplicationEntity getById(long id) {
			// database logic to read
						
			Configuration cfg = new Configuration(); // It creates a path or road between eclipse and database.
			cfg.setProperties(MysqlConnectionPropertiesUtil.getConnectionProperties());
			cfg.addAnnotatedClass(ApplicationEntity.class);	
			
			SessionFactory sessionFactory = cfg.buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			return session.get(ApplicationEntity.class, id);
			}
		
		public void update(ApplicationDto1 dto) {
			// database logic to update values
			
			//Here open database and get the row which has the altkey value and close the session.
			ApplicationEntity applicationEntity = getById(dto.getAltKey());
			
			// If we dont check this condition it will give null exception when passed key is not present inside a table.
			
			if(applicationEntity != null) {
				applicationEntity.setUserName(dto.getUserName());
				applicationEntity.setPassword(dto.getPassword());
				
				//Here again update values which has altkey value and updating it.
				saveApplicationDetails(applicationEntity);
				
//				Configuration cfg = new Configuration();
//				cfg.setProperties(MysqlConnectionPropertiesUtil.getConnectionProperties());
//				cfg.addAnnotatedClass(ApplicationEntity.class);
//				
//				SessionFactory sessionFactory = cfg.buildSessionFactory();
//				Session session = sessionFactory.openSession();
//				
//				Transaction transaction = session.beginTransaction();
//				session.merge(applicationEntity);
//				transaction.commit();
				
			}
			
		}

}
