package com.louis.kitty.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * 启动器
 * @author Louis
 * @date Oct 29, 2018
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class KittyMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(KittyMonitorApplication.class, args);
	}
}