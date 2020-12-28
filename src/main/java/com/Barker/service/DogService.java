package com.Barker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Barker.dao.DogDao;
import com.Barker.model.Dog;

// Written by Andrew Capp

@Service
public class DogService {
	
	@Autowired
	private DogDao dogDao;
	
	public List<Dog> getAllDogs() {
		return dogDao.findAll();
	}
	
	// Need to add parameter for dog preferences
	public List<Dog> getDogsByPreferences() {
		return dogDao.findAll();
	}
	
	public Dog getDogById(int id) {
		return dogDao.findById(id);
	}
	
	public Dog createDog(Dog dog, int shelter_id) {
		// need to get shelter from DB and add to dog object...
		return dogDao.save(dog);
	}

}
