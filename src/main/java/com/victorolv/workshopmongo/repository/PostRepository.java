package com.victorolv.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.victorolv.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository <Post, String > {

}
