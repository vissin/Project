package com.medicalabuseprevention.requestdto;

import com.medicalabuseprevention.model.Doctor;
import com.medicalabuseprevention.model.Patient;
import com.medicalabuseprevention.model.Prescription;
import com.medicalabuseprevention.model.Visit;
import java.util.List;

/**
 *
 * @author harpreetsi
 */
public class VisitDTO {
  
  private Long visitId;
  
  private Visit visitDTO;
  
  private Patient patientDTO;
  
  private Doctor doctorDTO;
  
  private List<Prescription> prescriptionDTO;

  public Long getVisitId() {
    return visitId;
  }

  public void setVisitId(Long visitId) {
    this.visitId = visitId;
  }

  public Visit getVisitDTO() {
    return visitDTO;
  }

  public void setVisitDTO(Visit visitDTO) {
    this.visitDTO = visitDTO;
  }

  public Patient getPatientDTO() {
    return patientDTO;
  }

  public void setPatientDTO(Patient patientDTO) {
    this.patientDTO = patientDTO;
  }

  public Doctor getDoctorDTO() {
    return doctorDTO;
  }

  public void setDoctorDTO(Doctor doctorDTO) {
    this.doctorDTO = doctorDTO;
  }

  public List<Prescription> getPrescriptionDTO() {
    return prescriptionDTO;
  }

  public void setPrescriptionDTO(List<Prescription> prescriptionDTO) {
    this.prescriptionDTO = prescriptionDTO;
  }
}
