package main.java.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import main.java.model.Person;
import main.java.model.Product;
import main.java.model.ProductCategory;

public class ORMConfig {

	public static Session createSession() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(Person.class)
				.addAnnotatedClass(ProductCategory.class).addAnnotatedClass(Product.class)
				.buildSessionFactory(serviceRegistry);
		return sessionFactory.openSession();
	}

}
