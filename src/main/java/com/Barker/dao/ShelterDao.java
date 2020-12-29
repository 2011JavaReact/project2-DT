package com.Barker.dao;

import java.util.ArrayList;
import com.Barker.model.*;
import org.hibernate.Session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


public interface ShelterDao extends JpaRepository<Shelter, Integer>{
	/*public ArrayList<Dog> populateDogs(int id){
		ArrayList<Dog> availableDogs = new ArrayList<>();
		return availableDogs;
	}*/
	
	public List<Shelter> findAll();
	
	public Shelter save(Shelter shelter);
	
	public Shelter findById(int id);
	
	public Shelter findByShelterName(String shelterName);
}
