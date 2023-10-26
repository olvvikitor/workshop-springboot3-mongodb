package com.victorolv.workshopmongo.dto;

import java.io.Serializable;
import java.util.Objects;

import com.victorolv.workshopmongo.domain.User;

public class AuthorDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private String name;
	
	public AuthorDto() {
		super();
	}
	public AuthorDto(User obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorDto other = (AuthorDto) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
