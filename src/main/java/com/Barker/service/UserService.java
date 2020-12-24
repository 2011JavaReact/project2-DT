package com.Barker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Barker.dao.UserDao;
import com.Barker.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User createUser(User user) {
		return user;
	}
	
	public List<User> getUsers() {
		return userDao.findAll();
	}
}
