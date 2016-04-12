package com.tscherrig.model.list;

import com.tscherrig.jpa.user.User;
import com.tscherrig.jpa.user.User.State;

public class ListUserItem {

	private State state;
	private long creation;
	private String email;
	private int id;

	public ListUserItem(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.creation = user.getCreationDate();
		this.state = user.getState();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public long getCreation() {
		return creation;
	}

	public void setCreation(long creation) {
		this.creation = creation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
