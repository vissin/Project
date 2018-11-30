package com.medicalabuseprevention.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "visit")
@NamedQueries(value = {
  @NamedQuery(name = "findVisitById", query = "SELECT p FROM Visit p where p.id =:visitId")}
)
public class Visit extends AbstractEntity {

  private Long patientId;


  private Long doctorId;


  private String weight;

  
  private BigDecimal height;

  private String bloodPressure;


  private Long temperature;

 
  private String prescriptionId;


  private boolean purchaseFlag;


  private Date visitDate;

  public String getBloodPressure() {
    return bloodPressure;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public Long getTemperature() {
    return temperature;
  }

  public void setTemperature(Long temperature) {
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

  public Long getPatientId() {
    return patientId;
  }

  public void setPatientId(Long patientId) {
    this.patientId = patientId;
  }

  public Long getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(Long doctorId) {
    this.doctorId = doctorId;
  }

  public BigDecimal getHeight() {
    return height;
  }

  public void setHeight(BigDecimal height) {
    this.height = height;
  }

  public Date getVisitDate() {
    return visitDate;
  }

  public void setVisitDate(Date visitDate) {
    this.visitDate = visitDate;
  }
}
