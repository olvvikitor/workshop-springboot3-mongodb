package com.victorolv.workshopmongo.dto;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


public class CommentDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String text;
	private Instant instant;

	
	private AuthorDto authorDto;

	public CommentDto() {
		super();
	}

	public CommentDto(String text, Instant instant,AuthorDto authoDto) {
		super();
		this.text = text;
		this.instant = instant;
		this.authorDto = authoDto;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getInstant() {
		return instant;
	}

	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	public AuthorDto getAuthorDto() {
		return authorDto;
	}

	public void setAuthorDto(AuthorDto authorDto) {
		this.authorDto = authorDto;
	}
}
