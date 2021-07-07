package com.ucamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UCampApplication {

	public static void main(String[] args) {
		SpringApplication.run(UCampApplication.class, args);
	}

}
