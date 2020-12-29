package com.Barker.dao;

// Written by Andrew Capp

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Barker.model.Dog;

public interface DogDao extends JpaRepository<Dog, Integer> {

	List<Dog> findAll();
	
	// need to add get dogs by user preferences
	
	public Dog findById(int id);
	
	public Dog save(Dog dog);
}
