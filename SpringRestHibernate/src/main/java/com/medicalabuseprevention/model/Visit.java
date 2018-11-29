package com.medicalabuseprevention.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="visit")
public class Visit extends AbstractEntity {
	
	
	@Column(name="PATIENT_ID")
	private String patientId;
	
	@Column(name="DOCTOR_ID")
	private String doctorId;
	
	@Column(name="WEIGHT")
	private long weight;
	
	@Column(name="HEIGHT")
	private String height;
	
	@Column(name="BP")
	private String bloodPressure;
	
	@Column(name="TEMPERATURE")
	private String temperature;
	
	@Column(name="PRESCRIPTION_ID")
	private String prescriptionId;
	
	@Column(name="PURCHASE_FLAG")
	private boolean purchaseFlag;
	
	@Column(name="DATE")
	private Date dateTime;
	
	@Column(name="VISITID")
	private String visitId;
	
	public String getVisitId() {
		return visitId;
	}
	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}
	public String getBloodPressure() {
		return bloodPressure;
	}
	
	public long getWeight() {
		return weight;
	}
	public void setWeight(long weight) {
		this.weight = weight;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public boolean isPurchaseFlag() {
		return purchaseFlag;
	}
	public void setPurchaseFlag(boolean purchaseFlag) {
		this.purchaseFlag = purchaseFlag;
	}
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
		
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}

	
	

}
