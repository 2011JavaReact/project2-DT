package com.Barker.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.Barker.model.Dog;

@Entity
@Table(name = "shelter")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Shelter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shelter_id")
	private int id;
	
	@Column(name = "shelter_name", length = 255)
	private String shelterName;
	
	@Column(name = "address", length = 255)
	private String address;
	
	@Column(name = "contact_info", length = 255)
	private String 	contactInfo;
	
	@OneToMany(mappedBy="shelter")
	private List<Dog> dogs; 
	
	//no args constructor
	public Shelter() {
		super();
	}
	
	//constructor
	public Shelter(int id, String shelterName, String address, String contactInfo) {
		this.id = id;
		this.shelterName = shelterName;
		this.address = address;
		this.contactInfo = contactInfo;
		//availableDogs = populateDogs(id); TODO: this should call a method in the dao that fetches all dogs associated with a shelter and returns them as an arraylist
	}
		
	// Setter and getter for ID.
	public int getId() {
		return id;
	}
		
	public void setId(int id) {
		this.id = id;
	}
	
	//setter and getter for shelter name
	public String getShelterName() {
		return shelterName;
	}
		
	public void setShelterName(String shelterName) {
		this.shelterName = shelterName;
	}
	
	//setter and getter for address
	public String getAdress() {
		return address;
	}
		
	public void setAddress(String address) {
		this.address = address;
	}
	
	//setter and getter for contact info
	public String getContactInfo() {
		return contactInfo;
	}
			
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	public String getAddress() {
		return address;
	}

	
}
