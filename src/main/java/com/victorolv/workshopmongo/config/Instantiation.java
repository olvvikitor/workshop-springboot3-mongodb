package com.victorolv.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.victorolv.workshopmongo.domain.Post;
import com.victorolv.workshopmongo.domain.User;
import com.victorolv.workshopmongo.dto.AuthorDto;
import com.victorolv.workshopmongo.dto.CommentDto;
import com.victorolv.workshopmongo.repository.PostRepository;
import com.victorolv.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

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
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post po1 = new Post(null, Instant.now(), "Viagem", "Primeira viagem com a familia", new AuthorDto(maria));
		Post po2 = new Post(null, Instant.now(), "Viagem", "Segunda viagem com a familia", new AuthorDto(maria));

		CommentDto c1 = new CommentDto("Lindas!!", Instant.now(), new AuthorDto(maria));
		CommentDto c2 = new CommentDto("Meu deus", Instant.now(), new AuthorDto(maria));
		CommentDto c3 = new CommentDto("Perfeita!!", Instant.now(), new AuthorDto(alex));
		CommentDto c4 = new CommentDto("Lindo por do sol", Instant.now(), new AuthorDto(bob));
		CommentDto c5 = new CommentDto("Aonde voces foram?", Instant.now(), new AuthorDto(alex));

		po1.getComents().addAll(Arrays.asList(c1, c2));
		po2.getComents().addAll(Arrays.asList(c4, c5));

		postRepository.saveAll(Arrays.asList(po1, po2));

		maria.getPosts().addAll(Arrays.asList(po1, po2));

		userRepository.save(maria);

	}

}
