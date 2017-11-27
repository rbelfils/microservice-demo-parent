package fr.keyteo.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerTestApp {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CustomerTestApp.class);
		app.setAdditionalProfiles("test");
		app.run(args);
	}

}
