package com.louis.kitty.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class KittyConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(KittyConfigApplication.class, args);
	}
}