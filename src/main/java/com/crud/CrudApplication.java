package com.crud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableSwagger2
@Import({SwaggerConfig.class})
public class CrudApplication {

    public static void main(String[] args) {

    
            SpringApplication.run(CrudApplication.class, args);
            // Crear un objeto TrayIcon y agregarlo a la bandeja del sistema
   
    }

}
