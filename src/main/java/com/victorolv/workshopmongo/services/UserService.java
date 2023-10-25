package com.victorolv.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorolv.workshopmongo.domain.User;
import com.victorolv.workshopmongo.dto.UserDTO;
import com.victorolv.workshopmongo.repository.UserRepository;
import com.victorolv.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario nao existe"));
	}

	public User insert(User obj) {
		return repo.insert(obj);

	}

	public User fromDTO(UserDTO objdto) {
		return new User(objdto.getId(), objdto.getName(), objdto.getEmail());
	}

	public  void delete(String id) {
		if (repo.existsById(id)) {
			 repo.deleteById(id);
		} else {
			throw new ObjectNotFoundException("Usuario nao existe");
		}
	}
	public User update(User obj) {
		findById(obj.getId());
		User entity = findById(obj.getId());
		updateData(entity, obj);
		return repo.save(entity);
		
	}
	public void updateData(User entity,User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
	}
}
