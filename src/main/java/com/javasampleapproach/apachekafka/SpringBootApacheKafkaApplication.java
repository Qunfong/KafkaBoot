package com.javasampleapproach.apachekafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringBootApacheKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApacheKafkaApplication.class, args);
	}
}
