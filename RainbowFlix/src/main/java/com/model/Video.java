package com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name ="Video")
public class Video  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String title;
	String href;
	String poster;
	int views;
	String description;
	int likes;
	int shares;
	

	@Temporal(TemporalType.DATE)
	Date date = new Date();
	
	Boolean isActive;
	

	@OneToMany(mappedBy = "video")
	List<History> histories;
	

	@OneToMany(mappedBy = "video")
	List<ShareVideo> shareVideo;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getHref() {
		return href;
	}


	public void setHref(String href) {
		this.href = href;
	}


	public String getPoster() {
		return poster;
	}


	public void setPoster(String poster) {
		this.poster = poster;
	}


	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}


	public int getShares() {
		return shares;
	}


	public void setShares(int shares) {
		this.shares = shares;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
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


	public List<ShareVideo> getShareVideo() {
		return shareVideo;
	}


	public void setShareVideo(List<ShareVideo> shareVideo) {
		this.shareVideo = shareVideo;
	}


	public Video(Long id, String title, String href, String poster, int views, String description, int likes, int shares,
			Date date, Boolean isActive, List<History> histories, List<ShareVideo> shareVideo) {
		super();
		this.id = id;
		this.title = title;
		this.href = href;
		this.poster = poster;
		this.views = views;
		this.description = description;
		this.likes = likes;
		this.shares = shares;
		this.date = date;
		this.isActive = isActive;
		this.histories = histories;
		this.shareVideo = shareVideo;
	}


	public Video() {
		super();
	}
	

}
