package com.food.city;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableBatchProcessing
@EnableSwagger2
public class CityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityApplication.class, args);
	}

}
