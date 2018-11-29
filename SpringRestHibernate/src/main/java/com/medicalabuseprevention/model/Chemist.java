package com.medicalabuseprevention.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="chemist")
public class Chemist extends AbstractEntity {
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="BIRTH_DATE")
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date birthDate;
	
	@Column(name="MOBILE")
	private long mobile;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="PASSWORD")
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	@Override
	public String toString() {
		return "Chemist [id=" + ", name=" + name
				+ ", birthdate=" + birthDate + ", mobile=" + mobile + ", email=" + email
				+ ", userId=" + userId + ", password=" +password+"]";
	}
	
}
