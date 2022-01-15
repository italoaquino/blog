package com.projeto.blog.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.projeto.blog.entities.Post;
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
	
	public Post findByGuid(String guid) {
		return this.repository.findByGuid(guid);
	}
	
	public Post add(Post post) {
		Post p1 = new Post();
		p1.setTittle(post.getTittle());
		p1.setDate(post.getDate());
		p1.setAuthor(post.getAuthor());
		p1.setText(post.getText());
		p1.setGuid(UUID.randomUUID().toString());
		return this.repository.save(p1);
	}
	
}
