package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account  implements Serializable{
	
	@Id
	String username;
	String fullname;
	String password;
	String email;
	String image;
	Boolean role;
	int liked;
	
	@OneToMany(mappedBy = "account")
	List<ShareVideo> shareVideo;
	
	int shares;
	Boolean isActive = true;
	
	@OneToMany(mappedBy = "account")
	List<History> histories;
	
	public Account() {
		super();
	}

	public Account(String username, String fullname, String password, String email, String image, Boolean role,
			int liked, List<ShareVideo> shareVideo, int shares, Boolean isActive, List<History> histories) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.email = email;
		this.image = image;
		this.role = role;
		this.liked = liked;
		this.shareVideo = shareVideo;
		this.shares = shares;
		this.isActive = isActive;
		this.histories = histories;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getRole() {
		return role;
	}

	public void setRole(Boolean role) {
		this.role = role;
	}

	public int getLiked() {
		return liked;
	}

	public void setLiked(int liked) {
		this.liked = liked;
	}

	public List<ShareVideo> getShareVideo() {
		return shareVideo;
	}

	public void setShareVideo(List<ShareVideo> shareVideo) {
		this.shareVideo = shareVideo;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<History> getHistories() {
		return histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}
	
	
	
	
}
