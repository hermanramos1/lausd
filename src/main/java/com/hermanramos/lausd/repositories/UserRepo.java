package com.hermanramos.lausd.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hermanramos.lausd.models.User;

@Repository
public interface UserRepo extends CrudRepository <User, Long> {
	User findByEmail(String email);
}
