package com.Barker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Barker.model.User;


public interface UserDao extends JpaRepository<User, Integer> {

	public List<User> findAll();
	
//	public User createUser(User user) {
//		Session session = sessionFactory.getCurrentSession();
//		
//		session.save(user);
//		return user;
//	}
}
