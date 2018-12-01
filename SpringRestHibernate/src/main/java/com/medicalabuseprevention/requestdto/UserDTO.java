package com.medicalabuseprevention.requestdto;

import com.medicalabuseprevention.model.Chemist;
import com.medicalabuseprevention.model.Doctor;
import com.medicalabuseprevention.model.Patient;

/**
 *
 * @author harpreetsi
 */
public class UserDTO {
  private String role;
  private String userId;
  private String result;
  private Doctor doctor;
  private Chemist chemist;
  private Patient patient;

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public Chemist getChemist() {
    return chemist;
  }

  public void setChemist(Chemist chemist) {
    this.chemist = chemist;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }
}
