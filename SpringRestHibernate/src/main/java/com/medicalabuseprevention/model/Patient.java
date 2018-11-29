package com.medicalabuseprevention.model;

import com.medicalabuseprevention.enums.Gender;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient extends AbstractEntity {

  @Column(name = "NAME")
  private String name;

  @Column(name = "BIRTH_DATE")
  private Date birthDate;

  @Column(name = "MOBILE")
  private long mobile;

  @Column(name = "GENDER")
  private Gender gender;

  @Column(name = "USER_ID")
  private long userId;

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

  public long getMobile() {
    return mobile;
  }

  public void setMobile(long mobile) {
    this.mobile = mobile;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
