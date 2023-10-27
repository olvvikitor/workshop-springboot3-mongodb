package com.victorolv.workshopmongo.config;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		// Creating User objects
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		// Creating Post objects with Date instead of Instant
		Post po1 = new Post(null, sdf.parse("21/03/2018"), "Viagem", "Primeira viagem com a familia", new AuthorDto(maria));
		Post po2 = new Post(null, sdf.parse("24/03/2018"), "Viagem", "Segunda viagem com a familia", new AuthorDto(maria));

		// Creating CommentDto objects with Date instead of Instant
		CommentDto c1 = new CommentDto("Lindas!!", sdf.parse("24/03/2018"), new AuthorDto(maria));
		CommentDto c2 = new CommentDto("Meu deus", sdf.parse("21/03/2018"), new AuthorDto(maria));
		CommentDto c3 = new CommentDto("Perfeita!!",sdf.parse("25/03/2018"), new AuthorDto(alex));
		CommentDto c4 = new CommentDto("Lindo por do sol", sdf.parse("27/03/2018"), new AuthorDto(bob));
		CommentDto c5 = new CommentDto("Aonde voces foram?", sdf.parse("22/03/2018"), new AuthorDto(alex));

		po1.getComents().addAll(Arrays.asList(c1, c2));
		po2.getComents().addAll(Arrays.asList(c4, c5));

		postRepository.saveAll(Arrays.asList(po1, po2));

		maria.getPosts().addAll(Arrays.asList(po1, po2));

		userRepository.save(maria);

	}

}
