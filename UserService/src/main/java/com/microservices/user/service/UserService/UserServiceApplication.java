package com.microservices.user.service.UserService;

import com.microservices.user.service.UserService.entities.Nft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class UserServiceApplication {
	
	@Autowired
	public RestTemplate restTemplate;

	public static void main(String[] args) {


		SpringApplication.run(UserServiceApplication.class, args);
	}

}
