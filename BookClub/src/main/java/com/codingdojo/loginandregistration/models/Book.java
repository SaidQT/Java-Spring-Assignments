package com.codingdojo.loginandregistration.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "Title cannot be empty")
	@Size(min = 3, max = 200, message = "Title must be at least 5 characters")
	private String title;
	@NotNull
	@Size(min = 5, max = 200, message = "Title must be at least 5 characters")
	private String author;
	@NotNull
	@Size(min = 5, message= "Message be at least 5 characters")
	@Column(columnDefinition="TEXT")
	private String myThoughts;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User user;

	public Book() {
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMyThoughts() {
		return myThoughts;
	}

	public void setMyThoughts(String myThoughts) {
		this.myThoughts = myThoughts;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(Object object) {
		this.user = (User) object;
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
