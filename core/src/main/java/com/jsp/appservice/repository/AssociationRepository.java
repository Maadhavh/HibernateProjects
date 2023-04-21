package com.jsp.appservice.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jsp.appservice.entity.VehicleEntity;
import com.jsp.appservice.util.SessionFactoryUtil;

public class AssociationRepository {
	
	public void saveVehicleDetails(VehicleEntity vehicle) {
		SessionFactory sessionfactory = SessionFactoryUtil.getSessionfactory();
		Session session = sessionfactory.openSession();
		Transaction transaction= session.beginTransaction();
		session.merge(vehicle);
		transaction.commit();
	}

}
