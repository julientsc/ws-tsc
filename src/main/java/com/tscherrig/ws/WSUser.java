package com.tscherrig.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tscherrig.jpa.item.Campaign;
import com.tscherrig.jpa.user.User;
import com.tscherrig.model.list.ListCampaignItem;
import com.tscherrig.model.list.ListUserItem;
import com.tscherrig.model.save.DetailCampaignItem;
import com.tscherrig.model.save.DetailUserItem;
import com.tscherrig.tools.HibernateUtil;

@Path("/user")
public class WSUser {

	private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@GET
	@Path("/")
	public Response list() {
		Session session = sessionFactory.openSession();

		List<ListUserItem> userList = new ArrayList<>();
		List<User> users = session.createCriteria(User.class).list();
		for (User user : users) {
			userList.add(new ListUserItem(user));
		}
		session.close();

		return Response.status(200).entity(GSON.toJson(userList)).build();
	}

	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") int id) {
		Session session = sessionFactory.openSession();
		User user = session.get(User.class, id);
		DetailUserItem detailUserItem = null;

		if (user != null) {
			detailUserItem = new DetailUserItem(user);
		}
		session.close();

		if (detailUserItem != null)
			return Response.status(200).entity(GSON.toJson(detailUserItem)).build();
		return Response.status(404).build();
	}

}
