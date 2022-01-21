package com.projeto.blog.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.blog.entities.Category;
import com.projeto.blog.entities.Post;
import com.projeto.blog.exception.ObjectNotFound;
import com.projeto.blog.repositories.PostRepository;
import com.projeto.blog.services.CategoryService;
import com.projeto.blog.services.PostService;

@Controller
public class PostController {

	private PostService service;
	private CategoryService catService;

	public PostController(PostService service, CategoryService catService) {
		this.service = service;
		this.catService = catService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("teste");
		List<Post> posts = this.service.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
	
	@RequestMapping(value = "/{guid}", method = RequestMethod.GET)
	public ModelAndView findByGuid(@PathVariable("guid") String guid) {
		Optional<Post> post = this.service.findByGuid(guid);
		ModelAndView mv = new ModelAndView("details");
		mv.addObject("post", post.get());
		return mv;
	}
	
	@RequestMapping(value = "/newPost", method = RequestMethod.GET)
	public String getForm(Post post, Model model) {
		model.addAttribute("category", catService.findAll());
		return "form";
	}
	
	@RequestMapping(value = "/gerenciar/atualizar/{guid}")
	public String update(@PathVariable("guid") String guid, Model model) {
		Optional<Post> post = this.service.findByGuid(guid);
		if(!post.isPresent()) {
			throw new ObjectNotFound("Objeto nao encontrado!");
		}
		model.addAttribute("post", post.get());
		model.addAttribute("category", catService.findAll());
		return "form";
	}
	
	@RequestMapping(value = "/newPost", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("post")  Post post,Model model, BindingResult bindingResult, RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("category", catService.findAll());
			return "redirect:/newPost";
		}
		this.service.add(post);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/gerenciar", method = RequestMethod.GET)
	public ModelAndView all() {
		ModelAndView mv = new ModelAndView("list");
		List<Post> posts = this.service.findAll();
		mv.addObject("posts", posts);
		return mv;
	} 
	
	
	
	@RequestMapping(value = "/gerenciar/{guid}", method = RequestMethod.GET)
	public String remove(@PathVariable("guid") String guid) {
		this.service.remove(guid);
		return "redirect:/gerenciar";
	}
	
}