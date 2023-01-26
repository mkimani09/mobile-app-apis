package com.faidihr.mobile.app.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"com.faidihr.authorization.service","com.faidihr.mobile.app.api"})
//@EnableJpaRepositories("com.faidihr.authorization.service.model.Repository")
public class MobileAppApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileAppApiApplication.class, args);
	}

}
