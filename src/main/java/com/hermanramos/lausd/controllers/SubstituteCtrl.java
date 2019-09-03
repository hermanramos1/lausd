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

import com.hermanramos.lausd.models.Comment;
import com.hermanramos.lausd.models.Job;
import com.hermanramos.lausd.models.User;
import com.hermanramos.lausd.services.SubstitutesService;





@Controller
public class SubstituteCtrl {
	@Autowired
	SubstitutesService sS;
	
    @RequestMapping("/home")
    public String loginAndReg(HttpSession session, Model model) {
    	if(session.getAttribute("user") != null) {
        	User user = (User) session.getAttribute("user");
        	model.addAttribute(user);
        	//getting a list of events outside of state
        	List<Job> allJobs = sS.getAllJobs();
        	model.addAttribute("allJobs", allJobs);
        	return "substitutes/home.jsp";
    	}
        return "redirect:/";
    }
    @RequestMapping("/jobs/newjob")
    public String displayNewJobForm(@ModelAttribute("jobObj")Job job) {
    	return "substitutes/newjob.jsp";
    }
    
    @PostMapping("/jobs")
    public String createNewJob(@Valid@ModelAttribute("jobObj")Job job, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "substitutes/newjob.jsp";
    }else {
    	User user = (User) session.getAttribute("user");
    	sS.createJob(job, user);
    	return "redirect:home";
    }
    }
    
    @RequestMapping("/jobs/{jobId}")
    public String viewJob(@PathVariable("jobId")Long id, Model model, @ModelAttribute("commentObj")Comment comment) {
    	Job job = sS.findById(id);
    	model.addAttribute("job", job);
    	List<Comment> comments = sS.getCommentsByJobId(id);
    	model.addAttribute("comments", comments);
    	return "substitutes/viewjob.jsp";
    }
    
    @PostMapping("/jobs/{jobId}/addComment")
    public String addCommentToJob(@Valid@ModelAttribute("commentObj")Comment comment, BindingResult result, @PathVariable("jobId")Long jobId, Model model, HttpSession session) {
    	if(result.hasErrors()) {
        	Job job = sS.findById(jobId);
        	model.addAttribute("job", job);
        	List<Comment> comments = sS.getCommentsByJobId(jobId);
        	model.addAttribute("comments", comments);
    		return "substitutes/viewjob.jsp";
    }
    	else {
    		User user = (User) session.getAttribute("user");
    		sS.addCommentToJob(comment, jobId, user);
    		return "redirect:/jobs/{jobId}";
    	}
    }
}
