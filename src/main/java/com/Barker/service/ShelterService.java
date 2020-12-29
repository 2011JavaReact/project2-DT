package com.Barker.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Barker.dao.ShelterDao;
import com.Barker.model.Shelter;
import com.Barker.model.User;

@Service
public class ShelterService {
	
	@Autowired
	private ShelterDao shelterDao;
	
	public Shelter createShelter(Shelter shelter) {
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
	
	/*public Shelter updateShelter() { create shelter dto
	 
	 	Shelter shelterToUpdate = shelterDAO.findById(
		
		shelterName
		address
		contactInfo
		
	}*/
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
