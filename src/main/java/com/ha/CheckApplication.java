package com.ha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

//@EnableAutoConfiguration
@EnableAuthorizationServer
@SpringBootApplication
public class CheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckApplication.class, args);
	}

}
