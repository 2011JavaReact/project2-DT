package com.Barker.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Barker.model.Shelter;
import com.Barker.service.ShelterService;
import com.Barker.dto.ShelterLoginDto;

import com.fasterxml.jackson.databind.ObjectMapper;
@CrossOrigin
@RestController
@RequestMapping("/shelterLogin")
public class ShelterLoginController {
	 @Autowired
	 private ShelterService shelterService;

	 @Autowired
	 private ObjectMapper objectMapper;
	 
	 @PostMapping("")
	 public void login(@RequestBody Shelter shelter, HttpServletResponse res) throws IOException {
		 if (shelterService.login(shelter)) {
			 System.out.println("Logged in successfully");
			 Shelter loggedInShelter = shelterService.getShelterByShelterName(shelter.getShelterName());
			 ShelterLoginDto shelterLoginDto = new ShelterLoginDto(loggedInShelter.getId(), loggedInShelter.getShelterName());
			 res.getWriter()
             	.append(objectMapper.writeValueAsString(shelterLoginDto));
		 }else {
	            res.getWriter().append("Incorrect shelter name or password.");
	            res.setStatus(401);
	     }
		 res.setContentType("application/json");
	 }
}
