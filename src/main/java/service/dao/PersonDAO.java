package main.java.service.dao;

import org.hibernate.Session;

import main.java.model.Person;
import main.java.model.exceptions.ProcessException;
import main.java.service.ORMConfig;

public class PersonDAO {

	public void insertNewUser(Person person) {
		Session session = ORMConfig.createSession();
		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();
		session.close();
	}

	public Person findUser(String userName, String email) {
		try (Session session = ORMConfig.createSession()) {
			Person person = (Person) session
					.createQuery("from Person p where p.principalName=:P1 and p.emailAddress=:P2")
					.setParameter("P1", userName).setParameter("P2", email).getSingleResult();
			if (person == null) {
				throw new ProcessException("This information about your user is incorrect");
			} else {
				return person;
			}
		}
	}

}
