package com.hermanramos.lausd.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hermanramos.lausd.models.Rating;

@Repository
public interface RatingRepo extends CrudRepository <Rating, Long> {

}
