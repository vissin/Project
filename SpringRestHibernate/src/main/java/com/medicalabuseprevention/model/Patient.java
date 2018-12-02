package com.medicalabuseprevention.model;

import com.medicalabuseprevention.enums.Gender;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins ="*", allowedHeaders="*")
@Entity
@Table(name = "patient")
@NamedQueries(value = {
  @NamedQuery(name = "findPatientById", query = "SELECT p FROM Patient p where p.id =:patId"),
  @NamedQuery(name = "findPatientByUserId", query = "SELECT p FROM Patient p where p.userId =:userId"),
    
}
)
public class Patient extends AbstractEntity {

  @Column(name = "NAME")
  private String name;

  @Column(name = "BIRTH_DATE")
  private Date birthDate;

  @Column(name = "MOBILE")
  private Long mobile;

  @Column(name = "GENDER")
  private Gender gender;

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

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public Long getMobile() {
    return mobile;
  }

  public void setMobile(Long mobile) {
    this.mobile = mobile;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
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
