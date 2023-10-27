package com.victorolv.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorolv.workshopmongo.domain.Post;
import com.victorolv.workshopmongo.repository.PostRepository;
import com.victorolv.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	public Post findById(String id){
		Optional<Post> posts = postRepository.findById(id);
		return posts.orElseThrow(()->new ObjectNotFoundException("Post nao encontrado"));
	}
	
	public List<Post> findAll(){
		return postRepository.findAll();
	}
	
}
