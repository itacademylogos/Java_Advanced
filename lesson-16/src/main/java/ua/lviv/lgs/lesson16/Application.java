package ua.lviv.lgs.lesson16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

		Client client = (Client) ctx.getBean("client");

		ConsoleEventLogger cel = (ConsoleEventLogger) ctx.getBean("consoleEventLogger");
		cel.logEvent(client.getId()+" ---> "+client.getUser().getFirstName()+" ---> "+client.getUser().getLastName());
	}
}
