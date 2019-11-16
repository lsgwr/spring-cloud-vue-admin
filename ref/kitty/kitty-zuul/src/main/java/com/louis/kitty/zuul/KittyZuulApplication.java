package com.louis.kitty.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class KittyZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(KittyZuulApplication.class, args);
	}
}