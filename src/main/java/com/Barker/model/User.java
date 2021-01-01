package com.Barker.model;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

// This model is for users that are looking for a dog to adopt.
// The shelter model is for users looking to create dogs available for adoption.

@Entity
@Table(name = "user_table")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	@Column(name = "user_name", length = 255)
	private String userName;

	@Column(name = "user_email", unique=true, length = 255)
	private String email;

	@Column(name = "user_password", length = 255)
	private String password;

// Use this field to determine if preferences should be used to limit the dogs shown to user.
	@Column(name = "preferences_set")
	private Boolean preferencesSet;

// These fields are for dog preferences

	@Column(name = "breed_preference", length = 255)
	private String breedPreference = "any";

	@Column(name = "age_preference", length = 255)
	private String agePreference = "any";

	@Column(name = "size_preference", length = 255)
	private String sizePreference = "any";

	@Column(name = "gender_preference", length = 255)
	private String genderPreference = "any";

	@Column(name = "good_with_preference", length = 255)
	private String goodWithPreference = "any";

	@Column(name = "coat_length_preference", length = 255)
	private String coatLengthPreference = "any";

	@Column(name = "energy_level_preference", length = 255)
	private String energyLevelPreference = "any";

	@ManyToMany
	@JoinTable(name = "dog_like", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "dog_id"))
	private List<Dog> likedDogs;
	
	@ManyToMany
	@JoinTable(name = "dog_dislike", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "dog_id"))
	private List<Dog> dislikedDogs;

	public User() {
		super();
	}
	
	// Used to create a new user (before any preferences are set)
	
	public User(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	
	public User(String userName, String email, String password, Boolean preferencesSet, String breedPreference,
			String agePreference, String sizePreference, String genderPreference, String goodWithPreference,
			String coatLengthPreference, String energyLevelPreference, List<Dog> likedDogs, List<Dog> dislikedDogs) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.preferencesSet = preferencesSet;
		this.breedPreference = breedPreference;
		this.agePreference = agePreference;
		this.sizePreference = sizePreference;
		this.genderPreference = genderPreference;
		this.goodWithPreference = goodWithPreference;
		this.coatLengthPreference = coatLengthPreference;
		this.energyLevelPreference = energyLevelPreference;
		this.likedDogs = likedDogs;
		this.dislikedDogs = dislikedDogs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getPreferencesSet() {
		return preferencesSet;
	}

	public void setPreferencesSet(Boolean preferencesSet) {
		this.preferencesSet = preferencesSet;
	}

	public String getBreedPreference() {
		return breedPreference;
	}

	public void setBreedPreference(String breedPreference) {
		this.breedPreference = breedPreference;
	}

	public String getAgePreference() {
		return agePreference;
	}

	public void setAgePreference(String agePreference) {
		this.agePreference = agePreference;
	}

	public String getSizePreference() {
		return sizePreference;
	}

	public void setSizePreference(String sizePreference) {
		this.sizePreference = sizePreference;
	}

	public String getGenderPreference() {
		return genderPreference;
	}

	public void setGenderPreference(String genderPreference) {
		this.genderPreference = genderPreference;
	}

	public String getGoodWithPreference() {
		return goodWithPreference;
	}

	public void setGoodWithPreference(String goodWithPreference) {
		this.goodWithPreference = goodWithPreference;
	}

	public String getCoatLengthPreference() {
		return coatLengthPreference;
	}

	public void setCoatLengthPreference(String coatLengthPreference) {
		this.coatLengthPreference = coatLengthPreference;
	}

	public String getEnergyLevelPreference() {
		return energyLevelPreference;
	}

	public void setEnergyLevelPreference(String energyLevelPreference) {
		this.energyLevelPreference = energyLevelPreference;
	}

	public List<Dog> getLikedDogs() {
		return likedDogs;
	}

	// Used to add a liked dog to the liked dogs join table
	// Must add both sides of many-to-many relationship to join table
	public void addLikedDog(Dog dog) {
		likedDogs.add(dog);
		dog.getLikes().add(this);
	}
	
	// Used to add a disliked to to the disliked dogs join table
	// Must add both sides of many-to-many relationship to join table
	public void addDislikedDog(Dog dog) {
		dislikedDogs.add(dog);
		dog.getDislikes().add(this);
	}
	
	public void setLikedDogs(List<Dog> likedDogs) {
		this.likedDogs = likedDogs;
	}

	public List<Dog> getDislikedDogs() {
		return dislikedDogs;
	}

	public void setDislikedDogs(List<Dog> dislikedDogs) {
		this.dislikedDogs = dislikedDogs;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + userName + ", email=" + email + ", password=" + password + ", preferencesSet="
				+ preferencesSet + ", breedPreference=" + breedPreference + ", agePreference=" + agePreference
				+ ", sizePreference=" + sizePreference + ", genderPreference=" + genderPreference
				+ ", goodWithPreference=" + goodWithPreference + ", coatLengthPreference=" + coatLengthPreference
				+ ", energyLevelPreference=" + energyLevelPreference + ", likedDogs=" + likedDogs + ", dislikedDogs="
				+ dislikedDogs + "]";
	}
	
	
	
	
}


