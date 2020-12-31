package com.Barker.service;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Barker.dao.ShelterDao;
import com.Barker.dto.UserDto;
import com.Barker.model.Shelter;
import com.Barker.model.User;

@Service
public class ShelterService {
	
	@Autowired
	private ShelterDao shelterDao;
	
	public Shelter createShelter(Shelter shelter) throws SQLException {
		return shelterDao.save(shelter);
	}
	
	public List<Shelter> getShelter() {
		return shelterDao.findAll();
	}
	
	public Shelter getShelterById(int id) {
		return shelterDao.findById(id);
	}
	
	public Shelter getShelterByShelterName(String shelterName) {
		return shelterDao.findByShelterName(shelterName);
	}
	
	public Shelter updateShelter(Shelter shelter) {
		// Retrieve shelter from DB (don't want to reset password)
		Shelter shelterToUpdate = shelterDao.findById(shelter.getId());
//		System.out.println(userToUpdate);
		
		shelterToUpdate.setShelterName(shelter.getShelterName());
		shelterToUpdate.setAddress(shelter.getAddress());
		shelterToUpdate.setContactInfo(shelter.getContactInfo());
		// Update shelter in database
		return shelterDao.save(shelterToUpdate);
	}

	public boolean login(Shelter shelter) {
		
		List<Shelter> shelters;
		shelters = shelterDao.findAll();
		for (Shelter value : shelters) {
			if (value.getShelterPassword().equals(shelter.getShelterPassword()) && value.getShelterName().equals(shelter.getShelterName())) {
				return true;
			}
		}
		return false;
	}
}
