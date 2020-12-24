package com.Barker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Barker.model.User;
import com.Barker.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
		
	@Autowired
	private UserService userService;
	
		@GetMapping("")
		public List<User> getUsers() {
			System.out.println("Get Users!!");
			return userService.getUsers();
		}
	
}
