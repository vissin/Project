package com.medicalabuseprevention.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins ="*", allowedHeaders="*")
@Entity
@Table(name = "USER")
@NamedQueries(value = { @NamedQuery(name = "fetchUserForAuth", query = "SELECT u FROM User u where u.name =:name and u.password =:password") })
public class User extends AbstractEntity {

	@Column(name = "NAME")
	private String name;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ROLE")
	private String role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", role="
				+ role + "]";
	}
	
	

}
