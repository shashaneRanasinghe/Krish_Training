package com.example.MicroservicersCloudConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroservicersCloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicersCloudConfigApplication.class, args);
	}

}
