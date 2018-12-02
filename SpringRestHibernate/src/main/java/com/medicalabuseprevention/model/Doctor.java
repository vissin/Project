package com.medicalabuseprevention.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins ="*", allowedHeaders="*")
@Entity
@Table(name = "doctor")
@NamedQueries(value = {
    @NamedQuery(name = "findDoctorById", query = "SELECT p FROM Doctor p where p.id =:doctorId"),
    @NamedQuery(name = "findDoctorByUserId", query = "SELECT p FROM Doctor p where p.userId =:userId")
  }
)
public class Doctor extends AbstractEntity {

  @Column(name = "NAME")
  private String name;

  @Column(name = "MOBILE")
  private long mobile;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "USER_ID")
  private String userId;

  @Column(name = "PASSWORD")
  private String password;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getMobile() {
    return mobile;
  }

  public void setMobile(long mobile) {
    this.mobile = mobile;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
