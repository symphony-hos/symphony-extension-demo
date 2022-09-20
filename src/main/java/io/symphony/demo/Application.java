package io.symphony.demo;

import io.symphony.extension.event.EnableSymphonyEventHandling;
import io.symphony.extension.point.EnableSymphonyPoint;
import io.symphony.extension.startup.EnableSymphonyStartup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableSymphonyPoint
@EnableSymphonyEventHandling
@EnableSymphonyStartup
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
	}

}
