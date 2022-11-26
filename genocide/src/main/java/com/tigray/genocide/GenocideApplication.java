package com.tigray.genocide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GenocideApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenocideApplication.class, args);
	}

	// @Bean
    // public Docket api() { 
    //     return new Docket(DocumentationType.SWAGGER_2)  
    //       .select()                                  
    //       .apis(RequestHandlerSelectors.any())              
    //       .paths(PathSelectors.any())                          
    //       .build();                                           
    // }

}
