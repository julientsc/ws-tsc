package com.tscherrig.jpa.user;

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

import antlr.Token;

@Entity
public class User {

	private int id;

	private UserAdministrator userAdministrator = null;
	private UserProduct userProduct = null;
	private UserCampaign userCampaign = null;
	private UserVisitor userVisitor = null;

	private String email;
	private String password;
	
	private Set<Token> tokens = new HashSet<>();

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
	
	
	@ManyToOne
    @JoinColumn(name="fk_userCampaign")
	public UserCampaign getUserCampaign() {
		return userCampaign;
	}

	public void setUserCampaign(UserCampaign userCampaign) {
		this.userCampaign = userCampaign;
	}

	@ManyToOne
    @JoinColumn(name="fk_userVisitor")
	public UserVisitor getUserVisitor() {
		return userVisitor;
	}

	public void setUserVisitor(UserVisitor userVisitor) {
		this.userVisitor = userVisitor;
	}

	@ManyToOne
    @JoinColumn(name="fk_userAdministrator")
	public UserAdministrator getUserAdministrator() {
		return userAdministrator;
	}

	public void setUserAdministrator(UserAdministrator userAdministrator) {
		this.userAdministrator = userAdministrator;
	}

	@ManyToOne
    @JoinColumn(name="fk_userProduct")
	public UserProduct getUserProduct() {
		return userProduct;
	}

	public void setUserProduct(UserProduct userProduct) {
		this.userProduct = userProduct;
	}

	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column
	public long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}
	
	@Column
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

//	@OneToMany
//	public Set<Token> getTokens() {
//		return tokens;
//	}
//
//	public void setTokens(Set<Token> tokens) {
//		this.tokens = tokens;
//	}
	
	
	

}
