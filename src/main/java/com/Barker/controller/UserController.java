package com.Barker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Barker.dto.UserDto;
import com.Barker.model.User;
import com.Barker.service.DogService;
import com.Barker.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
		
	@Autowired
	private UserService userService;
	
	@Autowired
	private DogService dogService;
	
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
		public User createUser(@RequestBody User user) {
			System.out.println("create user! " + user);
			
			return userService.createUser(user);
		}
	
		@GetMapping("/{userId}/dogs/{dogId}/like")
		public User likeDog(@PathVariable int userId, @PathVariable int dogId) {
			System.out.println("Like dog user: " + userId + " dog: " + dogId);
			User user = userService.getUserById(userId);
			user.addLikedDog(dogService.getDogById(dogId));
			return createUser(user);
		}
			
		@GetMapping("/{userId}/dogs/{dogId}/dislike")
		public User dislikeDog(@PathVariable int userId, @PathVariable int dogId) {
			System.out.println("Like dog user: " + userId + " dog: " + dogId);
			User user = userService.getUserById(userId);
			user.addDislikedDog(dogService.getDogById(dogId));
			return createUser(user);			
		}
		
		@PutMapping("/preferences")
		public User UpdateUserPreferences(@RequestBody UserDto userDto) {
			
			System.out.println("update user preferences! " + userDto);
			
			return userService.updateUserPreferences(userDto);
			
		}
		
		
}

