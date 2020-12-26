package com.Barker.dto;

import java.util.List;


public class UserDto {
	
	
	private int userId;

	private Boolean preferencesSet;

	private String breedPreference;

	private String agePreference;

	private String sizePreference;

	private String genderPreference;

	private String goodWithPreference;

	private String coatLengthPreference;

	private String energyLevelPreference;
	
	public UserDto() {
		super();
	}

	public UserDto(int userId, Boolean preferencesSet, String breedPreference, String agePreference, String sizePreference,
			String genderPreference, String goodWithPreference, String coatLengthPreference,
			String energyLevelPreference) {
		super();
		this.userId = userId;
		this.preferencesSet = preferencesSet;
		this.breedPreference = breedPreference;
		this.agePreference = agePreference;
		this.sizePreference = sizePreference;
		this.genderPreference = genderPreference;
		this.goodWithPreference = goodWithPreference;
		this.coatLengthPreference = coatLengthPreference;
		this.energyLevelPreference = energyLevelPreference;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", preferencesSet=" + preferencesSet + ", breedPreference=" + breedPreference
				+ ", agePreference=" + agePreference + ", sizePreference=" + sizePreference + ", genderPreference="
				+ genderPreference + ", goodWithPreference=" + goodWithPreference + ", coatLengthPreference="
				+ coatLengthPreference + ", energyLevelPreference=" + energyLevelPreference + "]";
	}
	
	
}
