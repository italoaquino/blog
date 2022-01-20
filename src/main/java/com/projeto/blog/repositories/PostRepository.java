package com.projeto.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.blog.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{


	Optional<Post> findByGuid(String guid);

}
