package com.victorolv.workshopmongo.config;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.victorolv.workshopmongo.domain.Post;
import com.victorolv.workshopmongo.domain.User;
import com.victorolv.workshopmongo.dto.AuthorDto;
import com.victorolv.workshopmongo.repository.PostRepository;
import com.victorolv.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

        
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post po1 = new Post(null,Instant.now(),"Viagem","Primeira viagem com a familia",new AuthorDto(maria));
		Post po2 = new Post(null,Instant.now(),"Viagem","Segunda viagem com a familia",new AuthorDto(bob));
		
		postRepository.saveAll(Arrays.asList(po1,po2));
		
		System.out.println(po1);
	}

}
