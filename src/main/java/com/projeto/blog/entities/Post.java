package com.projeto.blog.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String guid;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	private String subtitle; 
	
	@NotBlank
	@Lob
	private String text;
	
	@NotBlank
	private String tittle;
	
	@NotBlank
	private String author;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
	private LocalDate date;
	
	public Post() {
	}
	
	public Post(String text,String tittle, String author, Category category) {
		this.text = text;
		this.category = category;
		this.tittle = tittle;
		this.author = author;
	}

	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTittle() {
		return tittle;
	}

	

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	
	
	
	
}
