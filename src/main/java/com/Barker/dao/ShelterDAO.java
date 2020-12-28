package com.Barker.dao;

import java.util.ArrayList;
import com.Barker.model.*;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public class ShelterDAO {
	public ArrayList<Dog> populateDogs(int id){
		ArrayList<Dog> availableDogs = new ArrayList<>();
		Session session = factory.openSession();
	        session.beginTransaction();
		return availableDogs;
	}
}
