package com.victorolv.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorolv.workshopmongo.domain.User;
import com.victorolv.workshopmongo.repository.UserRepository;

@Service
public class UserService  {
	
	@Autowired
	private UserRepository repo; 
	
	public List<User>findAll(){
		return repo.findAll();
	}

}
