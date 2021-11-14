package com.mundomuebles.mundo_muebles_fd.infrastructure.controllers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2



public class SwaggerConfig {


    @Bean
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("CategoryController")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mundomuebles.mundo_muebles_fd.infrastructure.controllers"))
                .paths(PathSelectors.any()).build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Controller Manage Mundo Muebles FD ",
                "Service Rest API Mundo Muebles FD",
                "1.0",
                "http://www.umanizales.com/",
                new Contact("Juan Pablo Fernandez, Jhon Hanerson Muñoz", "http://www.umanizales.edu.co/",
                        "jpfernandez80823@umanizales.edu.co, jhmunoz81568@umanizales.edu.co"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }

}
