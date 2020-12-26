package com.Barker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Barker.dao.UserDao;
import com.Barker.dto.UserDto;
import com.Barker.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User createUser(User user) {
		return userDao.save(user);
	}
	
	public List<User> getUsers() {
		return userDao.findAll();
	}
	
	public User updateUserPreferences(UserDto userDto) {
		// Retrieve user from DB
		User userToUpdate = userDao.findById(userDto.getUserId());
//		System.out.println(userToUpdate);
		
		// Update preferences from userDto
		userToUpdate.setPreferencesSet(userDto.getPreferencesSet());
		userToUpdate.setBreedPreference(userDto.getBreedPreference());
		userToUpdate.setAgePreference(userDto.getAgePreference());
		userToUpdate.setSizePreference(userDto.getSizePreference());
		userToUpdate.setGenderPreference(userDto.getEnergyLevelPreference());
		userToUpdate.setGoodWithPreference(userDto.getGoodWithPreference());
		userToUpdate.setCoatLengthPreference(userDto.getCoatLengthPreference());
		userToUpdate.setEnergyLevelPreference(userDto.getEnergyLevelPreference());
		
		// Update user preferences in database
		return userDao.save(userToUpdate);
	}
}
