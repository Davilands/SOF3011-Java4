package com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table (name = "ShareVideo")
public class ShareVideo  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	Account account;
	
	@ManyToOne
	@JoinColumn(name="videoId")
	Video video;
	
	String email;
	
	@Temporal(TemporalType.DATE)
	Date shareDate = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getShareDate() {
		return shareDate;
	}

	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public ShareVideo(Long id, Account account, Video video, String email, Date shareDate) {
		super();
		this.id = id;
		this.account = account;
		this.video = video;
		this.email = email;
		this.shareDate = shareDate;
	}

	public ShareVideo() {
		super();
	}



}
