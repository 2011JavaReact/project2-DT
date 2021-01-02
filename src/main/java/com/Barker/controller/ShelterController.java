package com.Barker.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.Barker.model.Shelter;
import com.Barker.model.User;
import com.Barker.service.DogService;
import com.Barker.service.ShelterService;


@CrossOrigin
@RestController
@RequestMapping("/shelters")
public class ShelterController {
	
	@Autowired
	private ShelterService shelterService;
	
	@Autowired
	private DogService dogService;
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	
	@GetMapping("")
	public List<Shelter> getShelter() {
		System.out.println("Get Shelters");
		return shelterService.getShelter();
	}
	
	@GetMapping("/{id}")
	public Shelter getShelterById(@PathVariable int id) {
		return shelterService.getShelterById(id);
		
	}
	
	@PostMapping("")
	public Shelter createShelter(@RequestBody Shelter shelter) throws IOException {
//		System.out.println("create Shelter " + shelter);
	try {
		return shelterService.createShelter(shelter);
		} 
	catch (Exception e) {
		System.out.println("Error Message: "+e.getMessage());
		response.sendError(400, e.getMessage());
		return null;
	}
	}
	
	@PostMapping("/{shelterId}/dogs")
	public Dog createDog(@PathVariable int shelterId, @RequestBody Dog dog) {
		System.out.println("Create dog: " + shelterId);
		return dogService.createDog(dog, shelterId);
	}
	
	@PutMapping("/update")
	public Shelter UpdateShelter(@RequestBody Shelter shelter) {
		return shelterService.updateShelter(shelter);
	}
	
}

