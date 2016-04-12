package com.tscherrig.model.detail;

import com.tscherrig.jpa.gps.Coordinate;

public class DetailCoordinateItem {

	private int id;
	
	private double longitude;
	private double latitude;

	public DetailCoordinateItem(Coordinate coordinate) {
		this.id = coordinate.getId();
		this.latitude = coordinate.getLatitude();
		this.longitude = coordinate.getLongitude();
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
