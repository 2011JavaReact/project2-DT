package com.Barker.dto;

public class ShelterLoginDto {
	
	private int id;
    private String shelterName;
    
	public ShelterLoginDto() {
        super();
    }
	public ShelterLoginDto(int id , String shelterName) {
        this.id = id;
        this.shelterName = shelterName;
    }
		
	public int getId() {
        return id;
    }	
	public String getShelterName() {
        return shelterName;
    }
	public void setId(int id) {
        this.id = id;
    }
	public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }
}
