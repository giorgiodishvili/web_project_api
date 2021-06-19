package com.project.bookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;

//TODO add authorize support to swagger

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.project.bookstore.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInformation());
//                .useDefaultResponseMessages(false)
//                .globalResponseMessage(RequestMethod.GET, getCustomizedResponseMessages()
//                );
    }


    private ApiInfo getApiInformation() {
        return new ApiInfo("Room Reservation API",
                "Book room anywhere, anytime",
                "1.0",
                "API Terms of Service URL",
                new Contact("Giorgi Odishvili", "localhost:8080/", "odishvili.giorgi@gmail.com"),
                "API License",
                "API License URL",
                Collections.emptyList()
        );
    }

}
