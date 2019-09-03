package com.hermanramos.lausd.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hermanramos.lausd.models.Rating;
import com.hermanramos.lausd.models.RatingSchool;

@Repository
public interface RatingSchoolRepo extends CrudRepository<RatingSchool, Long>{


}
