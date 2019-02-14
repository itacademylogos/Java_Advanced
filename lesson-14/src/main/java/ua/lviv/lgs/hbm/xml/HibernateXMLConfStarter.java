package ua.lviv.lgs.hbm.xml;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateXMLConfStarter {
	public static void main(String[] args) {

		// create configuartion object with credentionls to DB
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

//		//create
//		Person person = new Person("Andrew","Horlovych",35);
//		session.persist(person);

//		//read single entity
//		Person personFromDB = (Person) session.get(Person.class,2);
//		System.out.println(personFromDB);

//		//get All from DB
//		List<Person> listOfPersons = session.createCriteria(Person.class).list();
//		listOfPersons.forEach(System.out::println);

//		//update entity
//		Person personForUpdate = (Person) session.get(Person.class, 1);
//		System.out.println(personForUpdate);
//		personForUpdate.setAge(80);
//		session.persist(personForUpdate);

		// delete
//		Person personForDelete = (Person) session.get(Person.class, 1);
//		session.delete(personForDelete);

		// create
		Person person = new Person("Andrew", "Horlovych", 35);
		Car car = new Car("Tesla");
		Car car2 = new Car("Audi");
		person.setCars(new HashSet<>(Arrays.asList(car, car2)));
		session.persist(person);

		transaction.commit();
		session.close();

	}

}
