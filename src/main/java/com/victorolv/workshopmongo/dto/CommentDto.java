package com.victorolv.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;



public class CommentDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String text;
	private Date instant;

	
	private AuthorDto authorDto;

	public CommentDto() {
		super();
	}

	public CommentDto(String text, Date instant,AuthorDto authoDto) {
		super();
		this.text = text;
		this.instant = instant;
		this.authorDto = authoDto;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
	}

	public Date getDate() {
		return instant;
	}

	public void setDate(Date instant) {
		this.instant = instant;
	}

	public AuthorDto getAuthorDto() {
		return authorDto;
	}

	public void setAuthorDto(AuthorDto authorDto) {
		this.authorDto = authorDto;
	}
}
