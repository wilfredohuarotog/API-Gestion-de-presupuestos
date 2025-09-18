package com.ppto.org.ppto_origen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PptoOrigenApplication {

	public static void main(String[] args) {
		SpringApplication.run(PptoOrigenApplication.class, args);
	}

}
