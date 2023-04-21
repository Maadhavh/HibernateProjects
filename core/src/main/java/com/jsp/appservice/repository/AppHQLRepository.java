package com.jsp.appservice.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.jsp.appservice.entity.ApplicationEntity;

import com.jsp.appservice.util.SessionFactoryUtil;

public class AppHQLRepository {

	public ApplicationEntity findAll(String password, String userName) {
		//String hql = "select password, userName from ApplicationEntity";
		StringBuilder builder  = new StringBuilder();
		builder.append("select password, userName from ApplicationEntity");
		builder.append(" where userName=: and password=:pswd");
		
		SessionFactory sessionfactory = SessionFactoryUtil.getSessionfactory();
		Session session = sessionfactory.openSession();
		Query queryResult = session.createQuery(builder.toString());
		return (ApplicationEntity)queryResult.getSingleResult();
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
