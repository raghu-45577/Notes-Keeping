package com.example.notekeepingbackend.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Table(name="Notes")
public class Note {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false)
	private String title;
	@Column(columnDefinition = "TEXT")
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date",nullable=false)
	private Date updatedDate=new Date(System.currentTimeMillis());
	
	
	
	public Note() {
		super();
	}


	public Note(long id, String title, String description, Date updatedDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.updatedDate = updatedDate;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
	

}
