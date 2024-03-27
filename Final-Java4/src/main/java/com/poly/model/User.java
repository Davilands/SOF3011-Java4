package com.poly.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long userid;
	String username;
	String email;
	String password;
	Boolean isActive = true;
	
	@OneToMany(mappedBy = "user")
	List<UserLog> userLogs;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<UserLog> getUserLogs() {
		return userLogs;
	}

	public void setUserLogs(List<UserLog> userLogs) {
		this.userLogs = userLogs;
	}

	public User(Long userid, String username, String email, String password, Boolean isActive, List<UserLog> userLogs) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.userLogs = userLogs;
	}

	public User() {
		super();
	}
	
	
	
}
