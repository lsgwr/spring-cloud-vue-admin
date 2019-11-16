package com.louis.kitty.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动器
 * @author Louis
 * @date Oct 29, 2018
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages={"com.louis.kitty"})
public class KittyBackupApplication {

	public static void main(String[] args) {
		SpringApplication.run(KittyBackupApplication.class, args);
	}
}