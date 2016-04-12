package com.tscherrig.model.detail;

import java.util.ArrayList;
import java.util.Set;

import com.tscherrig.jpa.gps.Area;

public class DetailAreaItem {

	private int id;
	 
	private long creation;
	private DetailCoordinateItem coordinate;
	private double radius;

	public DetailAreaItem(Area area) {
		this.id = area.getId();
		this.radius = area.getRadius();
		this.coordinate = new DetailCoordinateItem(area.getCoordinate());
		this.creation = area.getCreationDate();
	}

	public static ArrayList<DetailAreaItem> fromList(Set<Area> areas) {
		ArrayList<DetailAreaItem> items = new ArrayList<>();
		for (Area area : areas) {
			items.add(new DetailAreaItem(area));
		}
		return items;
	}

	public long getCreation() {
		return creation;
	}

	public void setCreation(long creation) {
		this.creation = creation;
	}

	public DetailCoordinateItem getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(DetailCoordinateItem coordinate) {
		this.coordinate = coordinate;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
