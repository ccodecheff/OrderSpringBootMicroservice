package com.example.egen.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import io.swagger.models.Tag;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    

    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com"))              
          .paths(PathSelectors.regex("/.*"))                         
          .build() .apiInfo(metaData());
                                                   
    }
    
    private ApiInfo metaData() {
    return new ApiInfoBuilder()
    .title("Ecommerce Order Processing")
    .description("\"Spring Boot REST API Excercise for Ecommerce Order Processing\"")
    .version("1.0.0")
    .license("Apache License Version 2.0")
    .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
    .build();
}

}
