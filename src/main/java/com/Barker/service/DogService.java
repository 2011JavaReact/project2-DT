package com.Barker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Barker.dao.DogDao;
import com.Barker.dao.ShelterDao;
import com.Barker.model.Dog;
import com.Barker.model.Shelter;
import com.Barker.model.User;

// Written by Andrew Capp

@Service
public class DogService {
	
	@Autowired
	private DogDao dogDao;
	
	@Autowired
	private ShelterDao shelterDao;
	
	public List<Dog> getAllDogs() {
		return dogDao.findAll();
	}
	
	// Need to add parameter for dog preferences
	public List<Dog> getDogsByPreferences() {
		return dogDao.findAll();
	}
	
	public List<String> getBreeds() {
		return dogDao.getBreeds();
	}
	
	// Get all dogs that are swipeable - not liked, not disliked, not adopted
		public List<Dog> getSwipeableDogs(int userId) {
			return dogDao.findSwipeableDogs(userId);
		}
		
	// Get all dogs that are swipeable and only with user's gender and breed preferences
		public List<Dog> getSwipeableDogsWithGenderAndBreed(User user) {
			
			return dogDao.findSwipeableDogsWithGenderAndBreed(user.getId(), user.getGenderPreference(), user.getBreedPreference());
		}
		
		
		// Get all dogs that are swipeable and only with user's gender preference
				public List<Dog> getSwipeableDogsWithGender(User user) {
					
					return dogDao.findSwipeableDogsWithGender(user.getId(), user.getGenderPreference());
				}
				
				// Get all dogs that are swipeable and only with user's breed preference
				public List<Dog> getSwipeableDogsWithBreed(User user) {
					
					return dogDao.findSwipeableDogsWithBreed(user.getId(), user.getBreedPreference());
				}
		
	public Dog getDogById(int id) {
		return dogDao.findById(id);
	}
	
	public Dog createDog(Dog dog, int shelterId) {
		// need to get shelter from DB and add to dog object...
		Shelter shelter = shelterDao.findById(shelterId);
		dog.setShelter(shelter);
		return dogDao.save(dog);
	}

}
