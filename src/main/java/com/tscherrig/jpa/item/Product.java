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

import com.tscherrig.jpa.process.Visit;
import com.tscherrig.jpa.user.UserProduct;

@Entity
public class Product {

	private int id;

	private String name;

	private String title;
	private String description;

	private long startProduct;
	private long stopProduct;

	private Set<Visit> visits = new HashSet<>();

	private UserProduct owner;
	
	public enum State {NONE, ACTIVED, DELETED};
	private State state = State.NONE;

	private long creationDate = new Date().getTime();;

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
	@JoinColumn(name = "fk_owner")
	public UserProduct getOwner() {
		return owner;
	}

	public void setOwner(UserProduct owner) {
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
	public long getStartProduct() {
		return startProduct;
	}

	public void setStartProduct(long startProduct) {
		this.startProduct = startProduct;
	}

	@Column
	public long getStopProduct() {
		return stopProduct;
	}

	public void setStopProduct(long stopProduct) {
		this.stopProduct = stopProduct;
	}

	@OneToMany(mappedBy = "product")
	public Set<Visit> getVisits() {
		return visits;
	}

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}

	@Column
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	


}
