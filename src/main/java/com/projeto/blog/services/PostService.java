package com.projeto.blog.services;

import java.util.List;

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
	
	public Post findById(Long id) {
		return this.repository.findById(id).get();
	}
	
	public Post add(Post post) {
		return this.repository.save(post);
	}
	
}
