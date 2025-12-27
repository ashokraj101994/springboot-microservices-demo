package com.ashok.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.user.dto.UserRequestDTO;
import com.ashok.user.dto.UserResponseDTO;
import com.ashok.user.exception.UserNotFoundException;
import com.ashok.user.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {
	
   @Autowired
   private UserService service;
   
   @GetMapping("/isUserExist/{uId}")
   public ResponseEntity<Boolean> getUserExist(@PathVariable int uId) {
	   boolean res = service.isUserExist(uId);
	   if(!res) {
		   throw new UserNotFoundException("User Not found for Id "+uId);
	   }
	   return new ResponseEntity<Boolean>(res,HttpStatus.OK);
   }
   
   @PostMapping("/createUser")
   public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO request){
	   UserResponseDTO res = service.saveUser(request);
	   return new ResponseEntity<UserResponseDTO>(res,HttpStatus.OK);
   }
}
