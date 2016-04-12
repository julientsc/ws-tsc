package com.tscherrig.jpa.item;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.tscherrig.jpa.gps.Area;
import com.tscherrig.jpa.process.Visit;
import com.tscherrig.jpa.user.UserCampaign;

@Entity
public class Campaign {

	private int id;

	private String name;
	private String description;

	private long startCampaign;
	private long stopCampaign;

	private Set<Visit> visits = new HashSet<>();
	private Set<Area> areas = new HashSet<>();

	private UserCampaign owner;

	public enum State {NONE, ACTIVED, DELETED};
	private State state = State.NONE;

	private long creationDate = new Date().getTime();
	
	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
    @JoinColumn(name="fk_owner")
	public UserCampaign getOwner() {
		return owner;
	}

	public void setOwner(UserCampaign owner) {
		this.owner = owner;
	}
	
	@Column
	public long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}

	@Column
	public long getStartCampaign() {
		return startCampaign;
	}

	public void setStartCampaign(long startCampaign) {
		this.startCampaign = startCampaign;
	}

	@Column
	public long getStopCampaign() {
		return stopCampaign;
	}

	public void setStopCampaign(long stopCampaign) {
		this.stopCampaign = stopCampaign;
	}
	
	@OneToMany(mappedBy = "campaign")
	public Set<Visit> getVisits() {
		return visits;
	}

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}
	
	@OneToMany
	public Set<Area> getAreas() {
		return areas;
	}

	public void setAreas(Set<Area> areas) {
		this.areas = areas;
	}
	
	

	@Column
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	

	
}
