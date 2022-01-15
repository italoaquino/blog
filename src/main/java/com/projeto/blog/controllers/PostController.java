package com.projeto.blog.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.blog.entities.Post;
import com.projeto.blog.services.PostService;

@Controller
public class PostController {

	private PostService service;
	
	public PostController(PostService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("post");
		List<Post> posts = this.service.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
	
	
	
}
