package com.Barker.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "dog")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Dog {

	//Specify this field as the ID for our entity.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dog_id")
	private int id;
	
	@Column(name = "dog_name", length = 255)
	private String name;
	
	@Column(name = "dog_age", length = 255)
	private String age;
	
	@Column(name = "dog_sex", length = 255)
	private String sex;
	
	@Column(name = "dog_breed", length = 255)
	private String breed;
	
	@Column(name = "dog_image", length = 255)
	private String image;
	
	@Column(name = "dog_location", length = 255)
	private String location;
	
	@Column(name = "dog_shedding_level", length = 255)
	private String sheddingLevel;
	
	@Column(name = "dog_energy_level", length = 255)
	private String energyLevel;
	
	@Column(name = "dog_bio", length = 255)
	private String bio;
	
	@Column(name = "is_adopted")
	private boolean isAdopted;
	
	@ManyToOne
	@JoinColumn(name="shelter_id", nullable=false)
	private Shelter shelter;
	
	@ManyToMany(mappedBy = "likedDogs")
	private List<User> likes;

	@ManyToMany(mappedBy = "dislikedDogs")
	private List<User> dislikes;
	
	// No-args constructor required by Hibernate.
	public Dog() {
		super();
	}
	
	// Constructor with all arguments except Shelter and ID which are  set separately.
	public Dog(String name, String age, String sex, String breed, String image, String location, 
			   String sheddingLevel, String energyLevel, String bio, boolean isAdopted) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.breed = breed;
		this.image = image;
		this.location = location;
		this.sheddingLevel = sheddingLevel;
		this.energyLevel = energyLevel;
		this.bio = bio;
		this.isAdopted = isAdopted;	
	}

	// Setter and getter for ID.
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	// Setter and getter for Name.
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// Setter and getter for Age.
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	// Setter and getter for Age.
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	// Setter and getter for Breed.
	public String getBreed() {
		return breed;
	}
	
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	// Setter and getter for Image URL.
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	// Setter and getter for Location.
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	// Setter and getter for Shedding Level.
	public String getSheddingLevel() {
		return sheddingLevel;
	}
	
	public void setSheddingLevel(String sheddingLevel) {
		this.sheddingLevel = sheddingLevel;
	}
	
	// Setter and getter for Energy Level.
	public String getEnergyLevel() {
		return energyLevel;
	}
	
	public void setEnergyLevel(String energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	// Setter and getter for Bio.
	public String getBio() {
		return bio;
	}
	
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	// Setter and getter for whether a dog is adopted or not.
	public boolean isAdopted() {
		return isAdopted;
	}
	
	public void setAdopted(boolean isAdopted) {
		this.isAdopted = isAdopted;
	}
	
	// Setters and getters for likes and dislikes join tables.
	
	public List<User> getLikes() {
		return likes;
	}

	public void setLikes(List<User> likes) {
		this.likes = likes;
	}

	public List<User> getDislikes() {
		return dislikes;
	}

	public void setDislikes(List<User> dislikes) {
		this.dislikes = dislikes;
	}

	
	public Shelter getShelter() {
		return shelter;
	}

	public void setShelter(Shelter shelter) {
		this.shelter = shelter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((bio == null) ? 0 : bio.hashCode());
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((energyLevel == null) ? 0 : energyLevel.hashCode());
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + (isAdopted ? 1231 : 1237);
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sheddingLevel == null) ? 0 : sheddingLevel.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (bio == null) {
			if (other.bio != null)
				return false;
		} else if (!bio.equals(other.bio))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (energyLevel == null) {
			if (other.energyLevel != null)
				return false;
		} else if (!energyLevel.equals(other.energyLevel))
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (isAdopted != other.isAdopted)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sheddingLevel == null) {
			if (other.sheddingLevel != null)
				return false;
		} else if (!sheddingLevel.equals(other.sheddingLevel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", breed=" + breed + ", image=" + image
				+ ", location=" + location + ", sheddingLevel=" + sheddingLevel + ", energyLevel=" + energyLevel
				+ ", bio=" + bio + ", isAdopted=" + isAdopted + "]";
	}
}
