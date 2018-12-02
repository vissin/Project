package com.medicalabuseprevention.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins ="*", allowedHeaders="*")
@Entity
@Table(name = "prescription")
@NamedQueries(value = {
  @NamedQuery(name = "findPrescriptionForVisitId", query = "SELECT p FROM Prescription p where p.visitId =:visitId"),
  @NamedQuery(name = "findPrescriptionById", query = "SELECT p FROM Prescription p where p.id =:id")})
public class Prescription extends AbstractEntity {

  @Column(name = "MEDICINE")
  private String medicine;

  @Column(name = "DOSAGE")
  private String dosage;

  @Column(name = "DAYS")
  private Long days;

  @Column(name = "TIMES")
  private Long times;

  @Column(name = "VISITID")
  private Long visitId;
  
  @Column(name = "PROVIDED", columnDefinition = "BIT", length = 1)
  private boolean provided;
  
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

  public boolean isProvided() {
    return provided;
  }

  public void setProvided(boolean provided) {
    this.provided = provided;
  }

  @Override
  public String toString() {
    return "Prescription [id=" + ", medicine=" + medicine
            + ", dosage=" + dosage + ", days=" + days + ", times=" + times
            + ", visitId=" + visitId + "]";
  }

}
