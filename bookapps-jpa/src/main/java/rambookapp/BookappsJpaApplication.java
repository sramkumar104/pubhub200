package rambookapp;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookappsJpaApplication {
	public static final Logger LOGGER=Logger.getLogger(BookappsJpaApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(BookappsJpaApplication.class, args);
		LOGGER.info("application start");
	}
}
