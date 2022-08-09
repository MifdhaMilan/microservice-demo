package com.mifdha.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class MicroserviceDemoApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDemoApiGatewayApplication.class, args);
	}

}
