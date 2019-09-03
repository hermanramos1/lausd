package com.hermanramos.lausd.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hermanramos.lausd.models.Comment;
import com.hermanramos.lausd.models.Rating;
import com.hermanramos.lausd.models.RatingSchool;
import com.hermanramos.lausd.models.School;
import com.hermanramos.lausd.models.User;
import com.hermanramos.lausd.repositories.CommentRepo;
import com.hermanramos.lausd.repositories.RatingRepo;
import com.hermanramos.lausd.repositories.RatingSchoolRepo;
import com.hermanramos.lausd.repositories.SchoolRepo;
import java.text.*;

@Service 
public class SchoolService {
	@Autowired
	SchoolRepo sR;
	@Autowired
	RatingRepo rR;
	@Autowired
	RatingSchoolRepo rSR;
	@Autowired 
	CommentRepo cR;
	
	public void createSchool(School school) {
		sR.save(school);
	}

	public List<School> getAllSchools() {
		return sR.findTop10ByOrderByIdDesc();
	}

	public School findSchoolById(Long schoolId) {
		Optional<School> optionalSchool = sR.findById(schoolId);
		if(optionalSchool.isPresent()) {
			return optionalSchool.get();
		}else {
			return null;
	}
	}

	public void addRatingToSchool(Rating rating, Long schoolId) {
		Rating ratingToAdd = rR.save(rating);
		School schoolToAdd = findSchoolById(schoolId);
		RatingSchool ratingSchool = new RatingSchool();
		ratingSchool.setRating(ratingToAdd);
		ratingSchool.setSchool(schoolToAdd);
		rSR.save(ratingSchool);
		
	}

	public String getRatingForSchool(School school) {
		List<Rating> listOfRatings = school.getRatings();
		int counter = 0;
		double sum = 0;
		double average = 0.0;
		for(Rating r : listOfRatings) {
			counter ++;
			sum += r.getRating();
		}
		average = sum / counter;
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(average);
		
		
	}

	public void addCommentToSchool(User user, Long schoolId, Comment comment) {
		comment.setUser(user);
		School school = findSchoolById(schoolId);
		comment.setSchool(school);
		cR.save(comment);
	}

	public List<Comment> getCommentsBySchoolId(Long schoolId) {
		return cR.findBySchoolId(schoolId);
	}

	public List<School> searchSchool(String schoolName) {
		List<School> schoolList = sR.findByNameContaining(schoolName);
		return schoolList;
	}
}
