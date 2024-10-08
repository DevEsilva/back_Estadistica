
package com.crud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author silvae
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
     @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.crud.controller")) // Reemplaza con el paquete de tus controladores
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    
     private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("API Rest Estadistica")
            .description("Documentación de la API Rest de Estadistica")
            .version("1.0")
            .build();
    }
}
