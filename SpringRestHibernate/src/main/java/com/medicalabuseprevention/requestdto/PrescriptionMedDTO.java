package com.medicalabuseprevention.requestdto;

/**
 *
 * @author harpreetsi
 */
public class PrescriptionMedDTO {
  private String medicine;
  private String dosage;
  private Long days;
  private Long times;

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
  
}
