package com.medicalabuseprevention.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="patient")
public class Patient {

	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="BIRTH_DATE")
	private Date birthDate;
	
	@Column(name="MOBILE")
	private long mobile;
	
	@Column(name="GENDER")
	private boolean gender;
	
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="ENCRYPTED_PASS")
	private String encryptionPassword;
	
	@Column(name="RELATIVE")
	private String relative;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getEncryptionPassword() {
		return encryptionPassword;
	}
	public void setEncryptionPassword(String encryptionPassword) {
		this.encryptionPassword = encryptionPassword;
	}
	public String getRelative() {
		return relative;
	}
	public void setRelative(String relative) {
		this.relative = relative;
	}
	
	
}
