package com.Barker.dto;


public class DogDto {

		private int id;
		private String name;
		private String age;
		private String sex;
		private String breed;
		private String image;
		private String sheddingLevel;
		private String energyLevel;
		private String bio;
		private boolean isAdopted;
		
		public DogDto() {
			super();
		}
		public DogDto(int id, String name, String age, String sex, String breed, String image,
				String sheddingLevel, String energyLevel, String bio, boolean isAdopted) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.sex = sex;
			this.breed = breed;
			this.image = image;
			this.sheddingLevel = sheddingLevel;
			this.energyLevel = energyLevel;
			this.bio = bio;
			this.isAdopted = isAdopted;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getBreed() {
			return breed;
		}
		public void setBreed(String breed) {
			this.breed = breed;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getSheddingLevel() {
			return sheddingLevel;
		}
		public void setSheddingLevel(String sheddingLevel) {
			this.sheddingLevel = sheddingLevel;
		}
		public String getEnergyLevel() {
			return energyLevel;
		}
		public void setEnergyLevel(String energyLevel) {
			this.energyLevel = energyLevel;
		}
		public String getBio() {
			return bio;
		}
		public void setBio(String bio) {
			this.bio = bio;
		}
		public boolean isAdopted() {
			return isAdopted;
		}
		public void setAdopted(boolean isAdopted) {
			this.isAdopted = isAdopted;
		}		
}
