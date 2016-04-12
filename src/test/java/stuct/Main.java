package stuct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tscherrig.jpa.item.Campaign;
import com.tscherrig.jpa.item.Product;
import com.tscherrig.jpa.user.User;
import com.tscherrig.jpa.user.UserAdministrator;
import com.tscherrig.jpa.user.UserCampaign;
import com.tscherrig.jpa.user.UserProduct;
import com.tscherrig.jpa.user.UserVisitor;
import com.tscherrig.tools.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		for(int i = 0 ; i < 10 ; i++) {
			User user = new User();
			
			UserAdministrator userAdministrator = new UserAdministrator();
			session.save(userAdministrator);
			user.setUserAdministrator(userAdministrator);
			
			UserProduct userProduct = new UserProduct();
			user.setUserProduct(userProduct);
			session.save(userProduct);
			for(int j = 0 ; j < 10 ; j++) {
				Product product = new Product();
				product.setOwner(userProduct);
				session.save(product);
				user.getUserProduct().getProducts().add(product);
			}
			
			UserCampaign userCampaign = new UserCampaign();
			user.setUserCampaign(userCampaign);
			session.save(userCampaign);
			for(int j = 0 ; j < 10 ; j++) {
				Campaign campaign = new Campaign();
				campaign.setOwner(userCampaign);
				session.save(campaign);
				user.getUserCampaign().getCampaigns().add(campaign);
			}
			
			UserVisitor userVisitor = new UserVisitor();
			session.save(userVisitor);
			user.setUserVisitor(userVisitor);
			
			session.save(user);
		}

		session.getTransaction().commit();

		session.close();

		sessionFactory.close();

	}

}
