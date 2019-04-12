package com.songservice.songservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication

public class SongserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongserviceApplication.class, args);
	}

}
