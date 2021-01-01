package com.Barker.dao;

// Written by Andrew Capp

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Barker.model.Dog;
import com.Barker.model.User;

public interface DogDao extends JpaRepository<Dog, Integer> {

	public List<Dog> findAll();
	
	// need to add get dogs by user preferences
	
	public Dog findById(int id);
	
	// Get all breeds from database for user preferences
	
	@Query(value="SELECT DISTINCT dog_breed FROM dog", nativeQuery = true)
	public List<String> getBreeds();
	
	public Dog save(Dog dog);
	
//	public List<Dog> findByLikedDogsIn(User user);
	
	// attempting to get dogs for a particular user that 1. are not adopted, 2. are not liked, 3. are not disliked
	
	@Query(
			value = "SELECT * FROM dog d WHERE d.is_adopted = FALSE AND d.dog_id NOT IN (SELECT dl.dog_id FROM dog_like dl WHERE dl.user_id = :userId) AND d.dog_id NOT IN (SELECT ddl.dog_id FROM dog_dislike ddl WHERE ddl.user_id = :userId)",
			nativeQuery = true)
	List<Dog> findSwipeableDogs(@Param("userId") int userId);


@Query(
		value = "SELECT * FROM dog d WHERE d.is_adopted = FALSE AND d.dog_id NOT IN (SELECT dl.dog_id FROM dog_like dl WHERE dl.user_id = :userId) AND d.dog_id NOT IN (SELECT ddl.dog_id FROM dog_dislike ddl WHERE ddl.user_id = :userId) AND d.dog_breed = :breed and d.dog_sex = :gender",
		nativeQuery = true)
List<Dog> findSwipeableDogsWithGenderAndBreed(@Param("userId") int userId, @Param("gender") String gender, @Param("breed") String breed);

@Query(
		value = "SELECT * FROM dog d WHERE d.is_adopted = FALSE AND d.dog_id NOT IN (SELECT dl.dog_id FROM dog_like dl WHERE dl.user_id = :userId) AND d.dog_id NOT IN (SELECT ddl.dog_id FROM dog_dislike ddl WHERE ddl.user_id = :userId) and d.dog_sex = :gender",
		nativeQuery = true)
List<Dog> findSwipeableDogsWithGender(@Param("userId") int userId, @Param("gender") String gender);

@Query(
		value = "SELECT * FROM dog d WHERE d.is_adopted = FALSE AND d.dog_id NOT IN (SELECT dl.dog_id FROM dog_like dl WHERE dl.user_id = :userId) AND d.dog_id NOT IN (SELECT ddl.dog_id FROM dog_dislike ddl WHERE ddl.user_id = :userId) and d.dog_breed = :breed",
		nativeQuery = true)
List<Dog> findSwipeableDogsWithBreed(@Param("userId") int userId, @Param("breed") String breed);

}



