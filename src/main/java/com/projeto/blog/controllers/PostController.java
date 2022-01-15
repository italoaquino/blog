package com.projeto.blog.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.blog.entities.Post;
import com.projeto.blog.services.PostService;

@Controller
public class PostController {

	private PostService service;
	
	public PostController(PostService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("post");
		List<Post> posts = this.service.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView findById(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("details");
		Post post = this.service.findById(id);
		mv.addObject("post", post);
		return mv;
	}
	
	@RequestMapping(value = "/newPost", method = RequestMethod.GET)
	public String getForm() {
		return "form";
	}
	
	
	@RequestMapping(value = "/newPost", method = RequestMethod.POST)
	public String add(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/newPost";
		}
		post.setDate(LocalDate.now());
		this.service.add(post);
		return "redirect:/";
	}
	
	
	
}
