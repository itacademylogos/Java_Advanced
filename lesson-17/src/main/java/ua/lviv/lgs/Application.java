package ua.lviv.lgs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.lgs.domain.Customer;
import ua.lviv.lgs.service.CustomerService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws ParseException {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		CustomerService service = ctx.getBean(CustomerService.class);

		Customer customer = new Customer();
		customer.setName("Jan");
		customer.setEmail("jan@mail.com");
		customer.setDate(new Date());

		// save user to DB
//		service.save(customer);

		// read from DB
		System.out.println(service.findById((long) 1));

		String target = "13-02-2019 13:00:00";
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date result = df.parse(target);

		System.out.println(service.findByDate(result));

		System.out.println(service.findByEmail("jan@mail.com"));
		
		// update from DB
		Customer forUpdate = service.findById((long) 5);
		forUpdate.setEmail("updatedMail@gmail.com");
		service.update(forUpdate);

		// readAll
		service.findAll().stream().forEach(System.out::println);
		
		service.deleteById((long)3);

	}
}
