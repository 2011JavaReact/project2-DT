package com.Barker.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Barker.dao.ShelterDAO;
import com.Barker.model.Shelter;
import com.Barker.model.User;

@Service
public class ShelterService {
	
	private ShelterDAO shelterDAO;
	
	public Shelter createShelter(Shelter shelter) {
		return shelterDAO.save(shelter);
	}
	
	public List<Shelter> getShelter() {
		return shelterDAO.findAll();
	}
	
	/*public Shelter updateShelter() { create shelter dto
	 
	 	Shelter shelterToUpdate = shelterDAO.findById(
		
		shelterName
		address
		contactInfo
		
	}*/
}
