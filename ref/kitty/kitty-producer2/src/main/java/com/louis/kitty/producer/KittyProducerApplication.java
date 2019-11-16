package com.louis.kitty.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class KittyProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KittyProducerApplication.class, args);
	}
}