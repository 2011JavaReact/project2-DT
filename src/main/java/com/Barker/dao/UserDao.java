package com.Barker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Barker.model.User;


public interface UserDao extends JpaRepository<User, Integer> {

	public List<User> findAll();
	
	public User save(User user);

	public User findById(int id);

	public User findByUserName(String userName);

	public User findByEmail(String email);
}
