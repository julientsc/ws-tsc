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
import com.tscherrig.model.list.ListCampaignItem;
import com.tscherrig.model.save.DetailCampaignItem;
import com.tscherrig.tools.HibernateUtil;

@Path("/campaign")
public class WSCampaign {
	
	private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@GET
	@Path("/")
	public Response list() {
		Session session = sessionFactory.openSession();
		
		List<ListCampaignItem> campaignsList = new ArrayList<>();
		List<Campaign> campaigns = session.createCriteria(Campaign.class).list();
		for (Campaign campaign : campaigns) {
			campaignsList.add(new ListCampaignItem(campaign));
		}
		session.close();
		
		return Response.status(200).entity(GSON.toJson(campaignsList)).build();
	}
	
	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") int id) {
		Session session = sessionFactory.openSession();
		Campaign campaign = session.get(Campaign.class, id);
		DetailCampaignItem detailCampaignItem = null;
		
		if(campaign != null) {
			detailCampaignItem = new DetailCampaignItem(campaign);
		}
		session.close();
		
		if(detailCampaignItem!=null)
			return Response.status(200).entity(GSON.toJson(detailCampaignItem)).build();
		return Response.status(404).build();
	}
	
}
