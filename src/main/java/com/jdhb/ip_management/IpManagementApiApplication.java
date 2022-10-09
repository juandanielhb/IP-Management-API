package com.jdhb.ip_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.jdhb.ip_management.repositories")
public class IpManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpManagementApiApplication.class, args);
	}

}
