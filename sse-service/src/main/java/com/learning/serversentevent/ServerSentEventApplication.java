package com.learning.serversentevent;

import com.learning.serversentevent.repository.ProductMongoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.learning.serversentevent.repository")
public class ServerSentEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerSentEventApplication.class, args);
	}

}
