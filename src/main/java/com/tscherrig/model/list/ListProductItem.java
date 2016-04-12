package com.tscherrig.model.list;

import com.tscherrig.jpa.item.Product;
import com.tscherrig.jpa.item.Product.State;

public class ListProductItem {

	private long stop;
	private long start;
	private State state;
	private int owner;
	private String name;
	private int id;

	public ListProductItem(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.owner = product.getOwner().getId();
		this.state = product.getState();
		this.start = product.getStartProduct();
		this.stop = product.getStopProduct();
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
