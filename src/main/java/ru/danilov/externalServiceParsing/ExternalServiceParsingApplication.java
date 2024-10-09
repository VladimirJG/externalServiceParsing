package ru.danilov.externalServiceParsing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExternalServiceParsingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExternalServiceParsingApplication.class, args);
	}

}
