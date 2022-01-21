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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.blog.entities.Category;
import com.projeto.blog.entities.Post;
import com.projeto.blog.services.CategoryService;

@Controller
public class CategoryController {

	private CategoryService service;
	
	public CategoryController(CategoryService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/")
	public ModelAndView findAll() {
		List<Category> categories =  this.service.findAll();
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("categories", categories);
		return mv;
	}
	
	
	
	
	
	
}
