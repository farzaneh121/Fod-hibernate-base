package main.java.service.dao;

import java.util.List;

import org.hibernate.Session;

import main.java.model.Product;
import main.java.service.ORMConfig;

public class ProductDAO {

	public List<Product> showAllProducts() {
		Session session = ORMConfig.createSession();
		List<Product> productList = session
				.createQuery("from Product p inner join fetch p.category c where c.versionID=1").list();
		session.close();
		return productList;
	}

	public Product findProductById(Integer productId) {
		Session session = ORMConfig.createSession();
		Product product = session.get(Product.class, productId);
		session.close();
		return product;
	}
}
