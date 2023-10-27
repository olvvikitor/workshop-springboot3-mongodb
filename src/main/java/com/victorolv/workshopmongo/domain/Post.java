package com.victorolv.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.victorolv.workshopmongo.dto.AuthorDto;
import com.victorolv.workshopmongo.dto.CommentDto;

@Document
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date instant;
	private String title;
	private String body;

	
	private AuthorDto author;
	
	private List<CommentDto> coments= new ArrayList<>();
	

	public Post() {
		super();
	}

	public Post(String id, Date instant, String title, String body, AuthorDto author) {
		super();
		this.id = id;
		this.instant = instant;
		this.title = title;
		this.body = body;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return instant;
	}

	public void setDate(Date instant) {
		this.instant = instant;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public AuthorDto getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDto author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public List<CommentDto> getComents() {
		return coments;
	}
	
	public void setComents(List<CommentDto> coments) {
		this.coments = coments;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}




}
