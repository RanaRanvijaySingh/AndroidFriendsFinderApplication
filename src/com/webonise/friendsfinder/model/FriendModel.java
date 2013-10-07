package com.webonise.friendsfinder.model;

public class FriendModel {
private String name;
private String location;
private String state;
private int id;
private double longitude;
private double latitude;
private String imageUrl;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public double getLongitude() {
	return longitude;
}
public void setLongitude(double longitude) {
	this.longitude = longitude;
}
public double getLatitude() {
	return latitude;
}
public void setLatitude(double latitude) {
	this.latitude = latitude;
}
public String getImageUrl() {
	return imageUrl;
}
public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}

}
