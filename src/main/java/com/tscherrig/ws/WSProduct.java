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
import com.tscherrig.jpa.item.Product;
import com.tscherrig.model.list.ListCampaignItem;
import com.tscherrig.model.list.ListProductItem;
import com.tscherrig.model.save.DetailCampaignItem;
import com.tscherrig.model.save.DetailProductItem;
import com.tscherrig.tools.HibernateUtil;

@Path("/product")
public class WSProduct {

	private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@GET
	@Path("/")
	public Response list() {
		Session session = sessionFactory.openSession();

		List<ListProductItem> productList = new ArrayList<>();
		List<Product> products = session.createCriteria(Product.class).list();
		for (Product product : products) {
			productList.add(new ListProductItem(product));
		}
		session.close();

		return Response.status(200).entity(GSON.toJson(productList)).build();
	}

	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") int id) {
		Session session = sessionFactory.openSession();
		Product product = session.get(Product.class, id);
		DetailProductItem detailProductItem = null;

		if (product != null) {
			detailProductItem = new DetailProductItem(product);
		}
		session.close();

		if (detailProductItem != null)
			return Response.status(200).entity(GSON.toJson(detailProductItem)).build();
		return Response.status(404).build();
	}

}
