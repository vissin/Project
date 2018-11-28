package com.medicalabuseprevention.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prescription")
public class Prescription {
	
	@Id
    @Column(name="ID")
    private long id;
	
	@Column(name="MEDICINE")
	private String medicine;
	
	 @Column(name="DOSAGE")
	private String dosage;
	
	 @Column(name="DAYS")
	private Long days;
	
	@Column(name="TIMES")
	private Long times;
	 
	@Column(name="VISITID")
	private Long visitId;
	 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public Long getDays() {
		return days;
	}

	public void setDays(Long days) {
		this.days = days;
	}

	public Long getTimes() {
		return times;
	}

	public void setTimes(Long times) {
		this.times = times;
	}

	public Long getVisitId() {
		return visitId;
	}

	public void setVisitId(Long visitId) {
		this.visitId = visitId;
	}

	@Override
	public String toString() {
		return "Prescription [id=" + id + ", medicine=" + medicine
				+ ", dosage=" + dosage + ", days=" + days + ", times=" + times
				+ ", visitId=" + visitId + "]";
	}
	
}
