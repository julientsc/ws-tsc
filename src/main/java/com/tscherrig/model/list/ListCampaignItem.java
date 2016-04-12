package com.tscherrig.model.list;

import com.tscherrig.jpa.item.Campaign;
import com.tscherrig.jpa.item.Campaign.State;

public class ListCampaignItem {

	private long stop;
	private long start;
	private State state;
	private int owner;
	private String name;
	private int id;

	public ListCampaignItem(Campaign campaign) {
		this.id = campaign.getId();
		this.name = campaign.getName();
		this.owner = campaign.getOwner().getId();
		this.state = campaign.getState();
		this.start = campaign.getStartCampaign();
		this.stop = campaign.getStopCampaign();
	}

	public long getStop() {
		return stop;
	}

	public void setStop(long stop) {
		this.stop = stop;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
