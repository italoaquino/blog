package com.projeto.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.blog.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	Optional<Category> findByGuid(String guid);

}
