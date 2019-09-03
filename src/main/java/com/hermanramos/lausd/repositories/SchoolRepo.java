package com.hermanramos.lausd.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.hermanramos.lausd.models.School;

@Repository
public interface SchoolRepo extends CrudRepository<School, Long>{
	List<School> findAll();

	List<School>findByNameContaining(String schoolName);
	
	List<School> findTop10ByOrderByIdDesc();
}
