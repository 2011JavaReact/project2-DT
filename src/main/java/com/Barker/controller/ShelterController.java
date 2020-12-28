package com.Barker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Barker.model.Shelter;
import com.Barker.model.User;
import com.Barker.service.ShelterService;


@CrossOrigin
@RestController
@RequestMapping("/shelters")
public class ShelterController {
	
	@Autowired
	private ShelterService shelterService;
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	
	@GetMapping("")
	public List<Shelter> getShelter() {
		System.out.println("Get Shelters");
		return shelterService.getShelter();
	}
	
	@PostMapping("")
	public Shelter createShelter(@RequestBody Shelter shelter) {
		System.out.println("create Shelter " + shelter);
		
		return shelterService.createShelter(shelter);
	}
	
}
