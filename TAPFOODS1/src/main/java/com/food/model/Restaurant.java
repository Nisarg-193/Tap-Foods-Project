package com.food.model;

public class Restaurant {
	private int restaurant_Id;
	private String name;
	private String cuisineType;
	private int deliveryTime;
	private String address;

	private double rating;
	private boolean isActive;
	private String ImagePath;
	
	

	public Restaurant() {
		super();
	}
	



	public Restaurant(int restaurant_Id,String name, String cuisineType, int deliveryTime, String address, double rating,
			boolean isActive,String ImagePath ) {
		super();
		this.restaurant_Id=restaurant_Id;
		this.name = name;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
		this.ImagePath = ImagePath;
	}
   

	public int getRestaurant_Id() {
		return restaurant_Id;
	}




	public void setRestaurant_Id(int restaurant_Id) {
		this.restaurant_Id = restaurant_Id;
	}


	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getCuisineType() {
		return cuisineType;
	}




	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}




	public int getDeliveryTime() {
		return deliveryTime;
	}




	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	




	public double getRating() {
		return rating;
	}




	public void setRating(double rating) {
		this.rating = rating;
	}




	public boolean isActive() {
		return isActive;
	}




	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


  public void setImagePath(String imagePath) {
	ImagePath = imagePath;
}
  
  public String getImagePath() {
	return ImagePath;
}



	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurant_Id + ", name=" + name + ", cuisineType=" + cuisineType
				+ ", deliveryTime=" + deliveryTime + ", address=" + address + ", adminUserId=" 
				+ ", rating=" + rating + ", isActive=" + isActive + "]";
	}




	

}
