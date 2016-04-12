package com.tscherrig.model.save;

import java.util.ArrayList;

import com.tscherrig.jpa.item.Campaign;
import com.tscherrig.model.detail.DetailAreaItem;
import com.tscherrig.model.detail.DetailVisitItem;
import com.tscherrig.model.list.ListCampaignItem;

public class DetailCampaignItem extends ListCampaignItem {

	private ArrayList<DetailVisitItem> visits = new ArrayList<>();
	private ArrayList<DetailAreaItem> areas = new ArrayList<>();

	public DetailCampaignItem(Campaign campaign) {
		super(campaign);

		this.visits = DetailVisitItem.fromList(campaign.getVisits());
		this.areas = DetailAreaItem.fromList(campaign.getAreas());
	}

	public ArrayList<DetailVisitItem> getVisits() {
		return visits;
	}

	public void setVisits(ArrayList<DetailVisitItem> visits) {
		this.visits = visits;
	}

	public ArrayList<DetailAreaItem> getAreas() {
		return areas;
	}

	public void setAreas(ArrayList<DetailAreaItem> areas) {
		this.areas = areas;
	}

}
