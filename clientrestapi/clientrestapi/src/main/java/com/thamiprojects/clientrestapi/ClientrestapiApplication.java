package com.thamiprojects.clientrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ClientrestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientrestapiApplication.class, args);
	}

}
