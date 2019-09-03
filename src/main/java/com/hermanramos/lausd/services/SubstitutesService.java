package com.hermanramos.lausd.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hermanramos.lausd.models.Comment;
import com.hermanramos.lausd.models.Job;
import com.hermanramos.lausd.models.User;
import com.hermanramos.lausd.repositories.CommentRepo;
import com.hermanramos.lausd.repositories.JobRepo;
import com.hermanramos.lausd.repositories.UserRepo;

@Service
public class SubstitutesService {
	@Autowired
	JobRepo jR;
	@Autowired 
	UserRepo uR;
	@Autowired 
	CommentRepo cR;
	
//	create a job and set user to Job
	public void createJob(Job job, User user) {
		job.setUser(user);
		jR.save(job);
		
	}

	public List<Job> getAllJobs() {
		return jR.findAllByOrderByIdDesc();
	}

	public Job findById(Long id) {
		Optional<Job> optionalJob = jR.findById(id);
		if(optionalJob.isPresent()) {
			return optionalJob.get();
		}else {
			return null;
	}
	}
	public User findUserById(Long id) {
		Optional<User> optionalUser = uR.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}else {
			return null;
	}
	}
	public void addCommentToJob(Comment comment, Long jobId, User user) {
		comment.setUser(user);
		Job job = findById(jobId);
		comment.setJob(job);
		cR.save(comment);
		
	}

	public List<Comment> getCommentsByJobId(Long id) {
		return cR.findByJobId(id);
	
	}
}
