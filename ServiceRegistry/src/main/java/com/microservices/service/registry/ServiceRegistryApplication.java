package com.microservices.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@EnableEurekaServer

public class ServiceRegistryApplication {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> squaredNumbersStream = numbers.stream().map(x -> x * x);
		System.out.println(squaredNumbersStream.toList());
//		squaredNumbersStream.forEach(System.out::println);
		SpringApplication.run(ServiceRegistryApplication.class, args);
	}

}
