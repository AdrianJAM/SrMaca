package com.srmaca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SrmacaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrmacaApplication.class, args);
	}

}