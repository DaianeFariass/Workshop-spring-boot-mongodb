package com.daianefarias.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.daianefarias.workshopmongo.domain.Post;
import com.daianefarias.workshopmongo.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContaining(String text);

}
