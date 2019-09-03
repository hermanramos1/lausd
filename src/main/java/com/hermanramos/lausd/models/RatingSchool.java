package com.hermanramos.lausd.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="ratings_schools")
public class RatingSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rating_id")
    private Rating rating;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="school_id")
    private School school;
    
    public RatingSchool() {
    	
    }
    
    
    
    
    

	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public Date getCreatedAt() {
		return createdAt;
	}






	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}






	public Date getUpdatedAt() {
		return updatedAt;
	}






	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}






	public Rating getRating() {
		return rating;
	}






	public void setRating(Rating rating) {
		this.rating = rating;
	}






	public School getSchool() {
		return school;
	}






	public void setSchool(School school) {
		this.school = school;
	}






	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
