package com.projeto.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.blog.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	Post findByGuid(String guid);

}
