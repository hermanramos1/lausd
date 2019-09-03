package com.hermanramos.lausd.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hermanramos.lausd.models.Job;
@Repository
public interface JobRepo extends CrudRepository<Job, Long> {
	List<Job> findAll();

	List<Job> findAllByOrderByIdDesc();
}
