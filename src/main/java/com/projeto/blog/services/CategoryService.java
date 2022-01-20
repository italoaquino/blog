package com.projeto.blog.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.projeto.blog.entities.Category;
import com.projeto.blog.exception.ObjectNotFound;
import com.projeto.blog.repositories.CategoryRepository;


@Service
public class CategoryService {

	private CategoryRepository repository;
	
	public CategoryService(CategoryRepository repository) {
		this.repository = repository;
	}
	
	public List<Category> findAll() {
		List<Category> categories = this.repository.findAll();
		return categories;
	}
	
	public Optional<Category> findByGuid(String guid) {
		Optional<Category> c1 = this.repository.findByGuid(guid);
		if(c1.isEmpty()){
			throw new ObjectNotFound("Objeto nao encontrado");
		}
		return c1;
	}
	
	public Category add(Category cat) {
		Category cat1 = new Category();
		cat.setGuid(UUID.randomUUID().toString());
		cat.setName(cat.getName());
		return this.repository.save(cat1);
		
	}
	
	
	

	
	public void Delete(String guid) {
		Optional<Category> c1 = this.repository.findByGuid(guid);
		if(c1.isEmpty()){
			throw new ObjectNotFound("Objeto nao encontrado");
		}
		this.repository.delete(c1.get());
	}
	
}
