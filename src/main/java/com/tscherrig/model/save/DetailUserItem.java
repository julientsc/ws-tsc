package com.tscherrig.model.save;

import com.tscherrig.jpa.user.User;
import com.tscherrig.model.list.ListUserItem;

public class DetailUserItem extends ListUserItem {

	public DetailUserItem(User user) {
		super(user);
		
		user.getUserAdministrator();
		user.getUserCampaign();
		user.getUserProduct();
		user.getUserVisitor();
		
	}
}
