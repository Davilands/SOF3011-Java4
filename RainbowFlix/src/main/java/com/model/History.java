package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="History")
public class History  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@ManyToOne
	@JoinColumn(name = "userId")
	Account account;
	
	@ManyToOne
	@JoinColumn(name = "videoId")
	Video video;

	@Temporal(TemporalType.DATE)
	Date viewsDate = new Date();

	Boolean isLike;

	@Temporal(TemporalType.DATE)
	Date likedDate = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getViewsDate() {
		return viewsDate;
	}

	public void setViewsDate(Date viewsDate) {
		this.viewsDate = viewsDate;
	}

	public Boolean getIsLike() {
		return isLike;
	}

	public void setIsLike(Boolean isLike) {
		this.isLike = isLike;
	}

	public Date getLikedDate() {
		return likedDate;
	}

	public void setLikedDate(Date likedDate) {
		this.likedDate = likedDate;
	}

	public History(Long id, Account account, Video video, Date viewsDate, Boolean isLike, Date likedDate) {
		super();
		this.id = id;
		this.account = account;
		this.video = video;
		this.viewsDate = viewsDate;
		this.isLike = isLike;
		this.likedDate = likedDate;
	}

	public History() {
		super();
	}
	
	
}
