package com.tscherrig.logical;

import com.tscherrig.jpa.item.Campaign;
import com.tscherrig.jpa.user.User;

public class Action {
	
	public static InCampaign createCampaign(User user, InCampaign campaign) {
		Campaign c = new Campaign();
		return null;
	}
	
	public InCampaign updateCampaign(User user,int id, InCampaign campaign) {
		return null;
	}
	
	public boolean deleteCampaign(User user,int id) {
		return false;
	}
	
	//
	
	public InProduct createProduct(User user,InProduct product) {
		return null;
	}
	
	public InProduct UpdateProduct(User user,int id, InProduct product) {
		return null;
	}
	
	public InProduct deleteProduct(User user,int id) {
		return null;
	}
	
	//
	
	public InVisit createVisit(User user,InVisit visit) {
		return null;
	}
}
