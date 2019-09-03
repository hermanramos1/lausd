package com.hermanramos.lausd.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hermanramos.lausd.models.Comment;
import com.hermanramos.lausd.models.Rating;
import com.hermanramos.lausd.models.School;
import com.hermanramos.lausd.models.User;
import com.hermanramos.lausd.services.SchoolService;

@Controller
public class SchoolCtrl {
	@Autowired 
	SchoolService sS;
	
	@RequestMapping("schools/new")
	public String displayFormToAddSchool(@ModelAttribute("schoolObj")School school) {
		return "schools/new.jsp";
	}
	
	@PostMapping("schools")
	public String addSchool(@Valid@ModelAttribute("schoolObj")School school, BindingResult result) {
    	if(result.hasErrors()) {
    		return "schools/new.jsp";
    }else {
    	sS.createSchool(school);
    	return "redirect:/schools";
    }
	}
   @RequestMapping ("schools")
   public String viewSchools(Model model) {
	   List<School> allSchools = sS.getAllSchools();
	   model.addAttribute("allSchools", allSchools);
	   return "schools/allschools.jsp";
	   
   }
   @RequestMapping("schools/{schoolId}")
   public String viewSchool(@PathVariable("schoolId")Long schoolId, Model model, @ModelAttribute("ratingObj")Rating rating, @ModelAttribute("commentObj")Comment comment) {
	   School school = sS.findSchoolById(schoolId);
	   model.addAttribute("school", school);
	   String schoolRating = sS.getRatingForSchool(school);
	   model.addAttribute("schoolRating", schoolRating);
	   List<Comment> allReviews = sS.getCommentsBySchoolId(schoolId);
	   model.addAttribute("allReviews", allReviews);
	   return "schools/view.jsp";
   }
   @PostMapping("schools/{schoolId}/addRating")
   public String addRatingToSchool(@Valid@ModelAttribute("ratingObj")Rating rating, BindingResult result, @PathVariable("schoolId")Long schoolId, HttpSession session, @ModelAttribute("commentObj")Comment comment, Model model) {
	   		if(result.hasErrors()) {
	   		    School school = sS.findSchoolById(schoolId);
	   		   	model.addAttribute("school", school);
	   		    String schoolRating = sS.getRatingForSchool(school);
	   		    model.addAttribute("schoolRating", schoolRating);
	   		    List<Comment> allReviews = sS.getCommentsBySchoolId(schoolId);
	   		    model.addAttribute("allReviews", allReviews);
	   			return "schools/view.jsp";
	   		}else {
		   		sS.addRatingToSchool(rating, schoolId);
	   			return "redirect:/schools/{schoolId}";
	   		}
   		}
   @PostMapping("schools/{schoolId}/addComment")
   public String addCommentToSchool(@Valid@ModelAttribute("commentObj")Comment comment, BindingResult result, @PathVariable("schoolId")Long schoolId, @ModelAttribute("ratingObj")Rating rating, HttpSession session, Model model) {
	   if(result.hasErrors()) {
  		    School school = sS.findSchoolById(schoolId);
  		   	model.addAttribute("school", school);
   		    String schoolRating = sS.getRatingForSchool(school);
   		    model.addAttribute("schoolRating", schoolRating);
   		    List<Comment> allReviews = sS.getCommentsBySchoolId(schoolId);
   		    model.addAttribute("allReviews", allReviews);
		   return "schools/view.jsp";
	   }else {
		   User user = (User) session.getAttribute("user");
		   sS.addCommentToSchool(user, schoolId, comment);
		   return "redirect:/schools/{schoolId}";	
	   }
   }
   @PostMapping("schools/search")
   public String searchSchool(@RequestParam("school")String schoolName, Model model, RedirectAttributes redirectAttributes) {
	   if(schoolName == "" || sS.searchSchool(schoolName).isEmpty()) {
		   redirectAttributes.addFlashAttribute("notfound", "No school was found.");
		   return "redirect:/schools";
	   }else {
		   List<School> schoolList = sS.searchSchool(schoolName);
		   model.addAttribute("foundSchools", schoolList);
		   List<School> allSchools = sS.getAllSchools();
		   model.addAttribute("allSchools", allSchools);
		   return "schools/results.jsp";
	   }

   }
   
  }
   


