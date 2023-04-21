package com.jsp.appservice.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="vehicle_info")
public class VehicleEntity implements Serializable {

	@GenericGenerator(name="auto", strategy = "increment")
	@GeneratedValue(generator="auto")
	@Id // Makes a column as primary key
	@Column(name = "alt_key")
	private long altkey;

	@Column(name = "vehicle_Name")
	private String vehicleName;

	@Column(name = "model_Number")
	private String modelNumber;

	@Column(name = "engine_Number")
	private String engineNumber;

	@Column(name = "price")
	private String price;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foreign_key")
	private RegistrationDetails regDetails;
	
	public long getAltkey() {
		return altkey;
	}

	public void setAltkey(long altkey) {
		this.altkey = altkey;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public RegistrationDetails getRegDetails() {
		return regDetails;
	}

	public void setRegDetails(RegistrationDetails regDetails) {
		this.regDetails = regDetails;
	}

	

}
