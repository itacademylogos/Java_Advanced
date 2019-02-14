package ua.lviv.lgs.lesson16;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {

	@Bean(name = "client")
	public Client getClient(@Qualifier("user") User user) {
		Client client = new Client(user);
		client.setId(1);
		return client;
	}

	@Bean(name = "consoleEventLogger")
	public ConsoleEventLogger getConsoleEventLogger() {
		return new ConsoleEventLogger();
	}

	@Bean(name = "user")
	public User getUser() {
		User user = new User();
		user.setFirstName("Vitalii");
		user.setLastName("Klichko");
		return user;
	}
}
