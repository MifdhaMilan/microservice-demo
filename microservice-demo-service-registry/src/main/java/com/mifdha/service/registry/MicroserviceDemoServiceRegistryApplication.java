package com.mifdha.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceDemoServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDemoServiceRegistryApplication.class, args);
	}


}
