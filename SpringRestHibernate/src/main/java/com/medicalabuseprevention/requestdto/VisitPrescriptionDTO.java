package com.medicalabuseprevention.requestdto;

import java.util.List;

/**
 *
 * @author harpreetsi
 */
public class VisitPrescriptionDTO {
  private String symptoms;
  private String height;
  private String weight;
  private String findings;
  private String followupDate;
  private List<PrescriptionMedDTO> medicine;
  private String bloodPressure;
  private String temprature;
  private Long patientId;
  private Long doctorId;  
  
  public String getSymptoms() {
    return symptoms;
  }

  public void setSymptoms(String symptoms) {
    this.symptoms = symptoms;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public String getFindings() {
    return findings;
  }

  public void setFindings(String findings) {
    this.findings = findings;
  }

  public String getFollowupDate() {
    return followupDate;
  }

  public void setFollowupDate(String followupDate) {
    this.followupDate = followupDate;
  }

  public List<PrescriptionMedDTO> getMedicine() {
    return medicine;
  }

  public void setMedicine(List<PrescriptionMedDTO> medicine) {
    this.medicine = medicine;
  }

  public String getBloodPressure() {
    return bloodPressure;
  }

  public void setBloodPressure(String bloodPressure) {
    this.bloodPressure = bloodPressure;
  }

  public String getTemprature() {
    return temprature;
  }

  public void setTemprature(String temprature) {
    this.temprature = temprature;
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
}
