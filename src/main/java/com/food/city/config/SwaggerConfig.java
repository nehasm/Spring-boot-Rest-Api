package com.food.city.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("City Food").apiInfo(apiInfo()).select()
                .paths(regex("/restaurants.*")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Restaurants in City")
                .description("Rest Api to give generic information about Restaurants")
                .build();
    }
}
