package com.ashok.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashok.user.dto.UserRequestDTO;
import com.ashok.user.dto.UserResponseDTO;
import com.ashok.user.entity.UserEntity;
import com.ashok.user.repo.UserRepository;

@Service
public class UserService {
	
   @Autowired
   private UserRepository repo;

   public boolean isUserExist(int id) {
	return repo.existsById(id);
   }

   public UserResponseDTO saveUser(UserRequestDTO request) {
	UserEntity user = new UserEntity(request.name(),request.email());
	user = repo.save(user);
	return new UserResponseDTO(user.getUserId(),user.getName(),user.getEmail());
   }
}
