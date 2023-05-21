package com.facens.facens_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FacensLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacensLearnApplication.class, args);
	}

}
