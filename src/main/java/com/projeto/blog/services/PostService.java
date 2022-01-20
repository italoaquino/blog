package com.projeto.blog.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import com.projeto.blog.entities.Category;
import com.projeto.blog.entities.Post;
import com.projeto.blog.exception.ObjectNotFound;
import com.projeto.blog.repositories.PostRepository;

@Service
public class PostService {
	
	private PostRepository repository;
	
	public PostService(PostRepository repository) {
		this.repository = repository;
	}

	public List<Post> findAll(){
		return this.repository.findAll();
	}
	
	public Optional<Post> findByGuid(String guid) {
		Optional<Post> post = this.repository.findByGuid(guid);
		if(!post.isPresent()) {
			throw new ObjectNotFound("Objeto nao encontrado");
		}
		return post;
	}
	
	public Post add(Post post) {
		Post p1 = new Post();
		p1.setTittle(post.getTittle());
		p1.setDate(LocalDate.now());
		p1.setAuthor(post.getAuthor());
		p1.setText(post.getText());
		p1.setGuid(UUID.randomUUID().toString());
		return this.repository.save(p1);
	}


	
	public void remove(String guid) {
		Optional<Post> p1 = this.repository.findByGuid(guid);
		this.repository.delete(p1.get());
	}
	
}
