package com.hermanramos.lausd.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hermanramos.lausd.models.Comment;

@Repository
public interface CommentRepo extends CrudRepository <Comment, Long>{
	List<Comment> findByJobId(Long id);
	List<Comment> findBySchoolId(Long id);
}
