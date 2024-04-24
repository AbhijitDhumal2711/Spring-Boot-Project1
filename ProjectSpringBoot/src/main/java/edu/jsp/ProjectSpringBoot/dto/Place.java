package edu.jsp.ProjectSpringBoot.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Place {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int placeId;
	
	private String placeName;

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Place [placeId=" + placeId + ", placeName=" + placeName + "]";
	}

	public Place() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
