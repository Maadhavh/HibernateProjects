package com.jsp.core;

import com.jsp.appservice.entity.RegistrationDetails;
import com.jsp.appservice.entity.VehicleEntity;
import com.jsp.appservice.repository.AssociationRepository;

public class App3 {

	public static void main(String[] args) {
		
		VehicleEntity vehicleEntity = new VehicleEntity();
		vehicleEntity.setVehicleName("tata Nexon");
		vehicleEntity.setPrice("10,00,000");
		vehicleEntity.setEngineNumber("petrol engine");
		vehicleEntity.setModelNumber("123");
		
		RegistrationDetails details = new RegistrationDetails();
		details.setRegDate("12-02-2016");
		details.setRegNumber("abc1245");

		vehicleEntity.setRegDetails(details);
		
		AssociationRepository repository = new AssociationRepository();
		repository.saveVehicleDetails(vehicleEntity);
	}

}
