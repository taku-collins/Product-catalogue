package com.product.crud;

//import io.swagger.annotations.Contact;
//import io.swagger.models.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author collins
 */


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    
    @Bean
    public Docket api(){
        
        return new Docket(DocumentationType.SWAGGER_2)
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.product.crud"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(metaInfo()); 
    
    //localhost:8080/swagger-ui.html
    }

    private ApiInfo metaInfo () {

        
    return new ApiInfoBuilder()
            .title("Spring Boot Product-Catalog API")
            .description("An API to Manage Product From Any Location")
            .contact(new Contact("JonkiPro",
                    "https://github.com/taku-collins/Product-Catalog-Project",
                    "unknows@unknown.com"))
            .license("Apach Licesen version 2.0")
            .licenseUrl("xxxxxxx/LICENSE")
            .version("1.0")
            .build();
        
    }
    
}
