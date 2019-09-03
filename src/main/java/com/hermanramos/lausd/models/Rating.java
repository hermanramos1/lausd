package com.hermanramos.lausd.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DecimalMax("10.0") @DecimalMin("0.0")
    private double rating;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "ratings_schools", 
    	joinColumns = @JoinColumn(name = "rating_id"), 
    	inverseJoinColumns = @JoinColumn(name = "school_id")
    )
  private List<School> schools;
    
  public Rating() {
	  
  }
  	
  
  
  

	public Long getId() {
	return id;
}





public void setId(Long id) {
	this.id = id;
}





public double getRating() {
	return rating;
}





public void setRating(double rating) {
	this.rating = rating;
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





public List<School> getSchools() {
	return schools;
}





public void setSchools(List<School> schools) {
	this.schools = schools;
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
    

