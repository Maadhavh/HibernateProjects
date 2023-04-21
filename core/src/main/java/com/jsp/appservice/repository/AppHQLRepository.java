package com.jsp.appservice.repository;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.jsp.appservice.entity.ApplicationEntity;

import com.jsp.appservice.util.SessionFactoryUtil;

public class AppHQLRepository {
	
	public String findByPassword(String password) {
		StringBuilder builder = new StringBuilder();
		builder.append("select password from ApplicationEntity where ");
		builder.append("password=: pswd");
		
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionfactory();
		Session session = sessionFactory.openSession();
		Query queryResult = session.createQuery(builder.toString());
		queryResult.setParameter("pswd", password);
		return (String) queryResult.getSingleResult();
		}
	
	public String findByUserName(String userName) {
		StringBuilder builder = new StringBuilder();
		builder.append("select userName from ApplicationEntity where ");
		builder.append("userName=: uName");
		
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionfactory();
		Session session = sessionFactory.openSession();
		Query queryResult = session.createQuery(builder.toString());
		queryResult.setParameter("uName", userName);
		
		try {
			System.out.println(queryResult.getSingleResult().getClass().getSimpleName());
			return  (String) queryResult.getSingleResult();
		} catch (NoResultException exception) {
			System.out.println(exception.getMessage());
		}
		return null;
		}

	public List<ApplicationEntity> findAll(String password, String userName) {
		//String hql = "select password, userName from ApplicationEntity";
		StringBuilder builder  = new StringBuilder();
		builder.append("from ApplicationEntity");
		builder.append(" where userName=:name and password=:pswd");
		
		SessionFactory sessionfactory = SessionFactoryUtil.getSessionfactory();
		Session session = sessionfactory.openSession();
		Query queryResult = session.createQuery(builder.toString());
		queryResult.setParameter("name", userName);
		queryResult.setParameter("pswd", password);
		return queryResult.getResultList();
	}
	
	public List<ApplicationEntity> findAl() {
		String hql = "select password, userName from ApplicationEntity";
		//StringBuilder builder  = new StringBuilder();
		//builder.append("from ApplicationEntity");
		
		SessionFactory sessionfactory = SessionFactoryUtil.getSessionfactory();
		Session session = sessionfactory.openSession();
		Query<ApplicationEntity> queryResult = session.createQuery(hql);
		System.out.println(queryResult.getResultList());
		return queryResult.getResultList();
	}
	
	public ApplicationEntity findByAppName(String applicationName) {
		StringBuilder builder  = new StringBuilder();
		builder.append("from ApplicationEntity where");//Here space should be given at the end of the where clause or staring of the second append().
		builder.append(" applicationName=:appName"); //appName is a variable here and it could be named with anything
		
		
		SessionFactory sessionfactory = SessionFactoryUtil.getSessionfactory();
		Session session = sessionfactory.openSession();
		Query queryResult = session.createQuery(builder.toString());
		queryResult.setParameter("appName", applicationName);
		return  (ApplicationEntity) queryResult.uniqueResult();// We use it when this method returns only one object
	}
	
	public void updateUrlByAppName(String url, String applicationName) {
		StringBuilder builder  = new StringBuilder();
		builder.append("update ApplicationEntity set");//Here space should be given at the end of the where clause or staring of the second append().
		builder.append(" url=:urlLink where "); //appName is a variable here and it could be named with anything\
		builder.append("applicationName=: appName");
		
		
		SessionFactory sessionfactory = SessionFactoryUtil.getSessionfactory();
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query queryResult = session.createQuery(builder.toString());
		queryResult.setParameter("urlLink", url);
		queryResult.setParameter("appName", applicationName);
		queryResult.executeUpdate();
		transaction.commit();
		
	}
}
