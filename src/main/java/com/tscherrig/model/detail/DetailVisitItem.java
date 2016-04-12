package com.tscherrig.model.detail;

import java.util.ArrayList;
import java.util.Set;

import com.tscherrig.jpa.process.Visit;

public class DetailVisitItem {

	private int id;
	
	private int campaign;
	private int owner;
	private int product;
	private long creation;
	
	private DetailCoordinateItem coordinates;

	public DetailVisitItem(Visit visit) {
		this.id = visit.getId();
		this.campaign = visit.getCampaign().getId();
		this.owner = visit.getOwner().getId();
		this.product = visit.getProduct().getId();
		this.creation = visit.getCreationDate();
		this.coordinates = new DetailCoordinateItem(visit.getCoordinate());
	}

	public static ArrayList<DetailVisitItem> fromList(Set<Visit> visits) {
		ArrayList<DetailVisitItem> items = new ArrayList<>();

		for (Visit visit : visits) {
			items.add(new DetailVisitItem(visit));
		}
		return items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCampaign() {
		return campaign;
	}

	public void setCampaign(int campaign) {
		this.campaign = campaign;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public long getCreation() {
		return creation;
	}

	public void setCreation(long creation) {
		this.creation = creation;
	}

	public DetailCoordinateItem getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(DetailCoordinateItem coordinates) {
		this.coordinates = coordinates;
	}

}
