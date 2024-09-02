package com.daianefarias.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.daianefarias.workshopmongo.domain.Post;
import com.daianefarias.workshopmongo.domain.User;
import com.daianefarias.workshopmongo.dto.AuthorDTO;
import com.daianefarias.workshopmongo.repository.PostRepository;
import com.daianefarias.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

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
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	
		Post post1 = new Post(null, sdf.parse("2018-03-21"), "Partiu viagem",  "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("2018-03-23"), "Bom dia",  "Acordei feliz hoje!", new AuthorDTO(alex));
			
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
