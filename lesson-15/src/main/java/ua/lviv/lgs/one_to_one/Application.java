package ua.lviv.lgs.one_to_one;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Application {
	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("/META-INF/hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		Session session = config.buildSessionFactory(serviceRegistry).openSession();

		Customer customer = new Customer();
		customer.setName("Vitalii3");
		customer.setEmail("someMail3@gmail.com");

		FinancialOperation operation = new FinancialOperation();
		operation.setDate(new Date());
		operation.setTotal(2050);
		customer.setFinancialOperation(operation);

		// save to DB
		Transaction transaction = session.beginTransaction();
		session.save(customer);
		transaction.commit();

		// read from DB
		Customer c = (Customer) session.get(Customer.class, 1);
		System.out.println(c + "--->" + c.getFinancialOperation());

		FinancialOperation financeOperation = (FinancialOperation) session.get(FinancialOperation.class, 2);
		System.out.println(financeOperation + "--->" + financeOperation.getCustomer());

	}
}
