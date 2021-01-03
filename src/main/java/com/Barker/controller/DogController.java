package com.Barker.controller;

import java.util.List;

// Written by Andrew Capp

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Barker.dto.DogDto;
import com.Barker.model.Dog;
import com.Barker.service.DogService;

@CrossOrigin
@RestController
@RequestMapping("/dogs")
public class DogController {
	
	@Autowired
	private DogService dogService;
	
	// Need to add condition for preferences when getting dogs - or maybe use a different url?
	
	@GetMapping("")
	public List<Dog> getAllDogs() {
		return dogService.getAllDogs();
	}
	
	@GetMapping("/{id}")
	public Dog getDogById(@PathVariable int id) {
		return dogService.getDogById(id);
	}
	
	@GetMapping("/breeds")
	public List<String> getDogBreeds() {
		return dogService.getBreeds();
	}
	
	@PutMapping("/update")
	public Dog UpdateDog(@RequestBody DogDto dogDto) {
		return dogService.updateDog(dogDto);
	}
	
	// For create dog, should we use the Shelter Controller?  Example Route: /shelter/{id}/dog/new...
	
//	@PostMapping("")
//	public Dog createDog() {
//		
//	}
}
