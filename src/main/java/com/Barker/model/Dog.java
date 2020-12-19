package com.Barker.model;

public class Dog {

	private int id;
	private String name;
	private String age;
	private String breed;
	private String image;
	private String location;
	private String sheddingLevel;
	private String energyLevel;
	private String bio;
	private boolean isAdopted;
	
	// No-args constructor required by Spring.
	public Dog() {
		super();
	}
	
	// Constructor with all arguments. ID is set separately.
	public Dog(String name, String age, String breed, String image, String location, 
			   String sheddingLevel, String energyLevel, String bio, boolean isAdopted) {
		super();
		this.name = name;
		this.age = age;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((bio == null) ? 0 : bio.hashCode());
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
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
		return "Dog [id=" + id + ", name=" + name + ", age=" + age + ", breed=" + breed + ", image=" + image
				+ ", location=" + location + ", sheddingLevel=" + sheddingLevel + ", energyLevel=" + energyLevel
				+ ", bio=" + bio + ", isAdopted=" + isAdopted + "]";
	}
}
