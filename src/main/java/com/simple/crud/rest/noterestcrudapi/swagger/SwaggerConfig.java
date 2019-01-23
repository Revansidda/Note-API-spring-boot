package com.simple.crud.rest.noterestcrudapi.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//swagger url http://localhost:8080/v2/api-docs
//http://localhost:8080/swagger-ui.html
//http://localhost:8080/actuator

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return  new Docket(DocumentationType.SWAGGER_2);

    }

}
