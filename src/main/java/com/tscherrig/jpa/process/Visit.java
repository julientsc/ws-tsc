package com.tscherrig.jpa.process;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tscherrig.jpa.gps.Coordinate;
import com.tscherrig.jpa.item.Campaign;
import com.tscherrig.jpa.item.Product;
import com.tscherrig.jpa.item.Campaign.State;
import com.tscherrig.jpa.user.UserVisitor;

@Entity
public class Visit {

	private int id;

	private Coordinate coordinate;
	private Product product;
	private Campaign campaign;

	private long creationDate = new Date().getTime();;
	
	private UserVisitor owner;

	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "fk_coordinate")
	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	@ManyToOne
	@JoinColumn(name = "fk_product")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne
	@JoinColumn(name = "fk_owner")
	public UserVisitor getOwner() {
		return owner;
	}

	public void setOwner(UserVisitor owner) {
		this.owner = owner;
	}
	
	@Column
	public long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}

	@ManyToOne
	@JoinColumn(name = "fk_campaign")
	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}
	


	

}
