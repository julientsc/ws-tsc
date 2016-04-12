package com.tscherrig.model.save;

import java.util.ArrayList;

import com.tscherrig.jpa.item.Product;
import com.tscherrig.model.detail.DetailVisitItem;
import com.tscherrig.model.list.ListProductItem;

public class DetailProductItem extends ListProductItem {

	private ArrayList<DetailVisitItem> visits = new ArrayList<>();

	public DetailProductItem(Product product) {
		super(product);
		this.visits = DetailVisitItem.fromList(product.getVisits());
	}

	public ArrayList<DetailVisitItem> getVisits() {
		return visits;
	}

	public void setVisits(ArrayList<DetailVisitItem> visits) {
		this.visits = visits;
	}

}
