package com.Barker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Barker.model.User;
import com.Barker.service.UserService;

//@CrossOrigin(origins = "http://localhost:3000, http://127.0.0.1")
@RestController
@RequestMapping("/users")
public class UserController {
		
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
		@GetMapping("")
		public List<User> getUsers() {
			System.out.println("Get Users!!");
			return userService.getUsers();
		}
		
		@PostMapping("")
		public User createUser(@RequestBody User user2) {
			System.out.println("create user! " + user2);
			User user = new User();
			user.setName("Andrew");
			user.setEmail("acapp909@gmail.com");
			user.setPassword("1111");
			return userService.createUser(user);
		}
	
}

