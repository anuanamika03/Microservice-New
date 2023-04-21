package com.example.eurekaClientApplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication1.class, args);
	}



}
