package com.poly.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_logs")
public class UserLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long log_id;
	
	@ManyToOne
	@JoinColumn( name = "userid")
	User user;
	
	Date login_time;
	Date logout_time;
	public Long getLog_id() {
		return log_id;
	}
	public void setLog_id(Long log_id) {
		this.log_id = log_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}
	public Date getLogout_time() {
		return logout_time;
	}
	public void setLogout_time(Date logout_time) {
		this.logout_time = logout_time;
	}
	public UserLog(Long log_id, User user, Date login_time, Date logout_time) {
		super();
		this.log_id = log_id;
		this.user = user;
		this.login_time = login_time;
		this.logout_time = logout_time;
	}
	public UserLog() {
		super();
	}
	
	
	
}
