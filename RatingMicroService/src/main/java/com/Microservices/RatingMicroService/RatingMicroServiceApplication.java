package com.Microservices.RatingMicroService;

import com.netflix.discovery.EurekaClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class RatingMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingMicroServiceApplication.class, args);
	}

}
