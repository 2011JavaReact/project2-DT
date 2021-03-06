package com.Barker.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Barker.dto.UserDto;
import com.Barker.model.Dog;
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
		
		@GetMapping("/{id}")
		public User getUserById(@PathVariable int id) {
			return userService.getUserById(id);
		}
		
		@PostMapping("")
		public User createUser(@RequestBody User user) throws IOException {
//			System.out.println("create user! " + user);
			try {
			return userService.createUser(user);
			}
			catch (Exception e) {
				System.out.println("Error Message: "+e.getMessage());
				response.sendError(400, e.getMessage());
				return null;
			}
		}
	
		@GetMapping("/{userId}/dogs/{dogId}/like")
		public User likeDog(@PathVariable int userId, @PathVariable int dogId) throws IOException {
			System.out.println("Like dog user: " + userId + " dog: " + dogId);
			User user = userService.getUserById(userId);
			user.addLikedDog(dogService.getDogById(dogId));
			return createUser(user);
		}
		
		@GetMapping("/{userId}/dogs/{dogId}/unlike")
		public User unlikeDog(@PathVariable int userId, @PathVariable int dogId) throws IOException {
			System.out.println("Unlike dog user: " + userId + " dog: " + dogId);
			User user = userService.getUserById(userId);
			user.unlikeDog(dogService.getDogById(dogId));
			return createUser(user);
		}
			
		@GetMapping("/{userId}/dogs/{dogId}/dislike")
		public User dislikeDog(@PathVariable int userId, @PathVariable int dogId) throws IOException {
			System.out.println("Like dog user: " + userId + " dog: " + dogId);
			User user = userService.getUserById(userId);
			user.addDislikedDog(dogService.getDogById(dogId));
			return createUser(user);			
		}
		
				
		// Get dogs that are not adopted, liked, or disliked for viewing on swipe page
		@GetMapping("/{userId}/dogs")
		public List<Dog> getDogs(@PathVariable int userId) {
			User user = userService.getUserById(userId);
			if (!user.getGenderPreference().equals("any") && !user.getBreedPreference().equals("any")) {
				return dogService.getSwipeableDogsWithGenderAndBreed(user);
			} else if (!user.getGenderPreference().equals("any")) {
				return dogService.getSwipeableDogsWithGender(user);
			} else if (!user.getBreedPreference().equals("any")) {
				return dogService.getSwipeableDogsWithBreed(user);
			} else {
				return dogService.getSwipeableDogs(userId);
			}
			
		
		}
		
		@PutMapping("/update")
		public User UpdateUser(@RequestBody UserDto userDto) {
			return userService.updateUser(userDto);
		}
		
		@PutMapping("/preferences")
		public User UpdateUserPreferences(@RequestBody UserDto userDto) {
			
			System.out.println("update user preferences! " + userDto);
			
			return userService.updateUserPreferences(userDto);
			
		}
		
		
}

