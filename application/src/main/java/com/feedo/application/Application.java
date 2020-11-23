package com.feedo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@EnableJpaRepositories("com.feedo.persistence_postgres.repositories")
@EntityScan("com.feedo.persistence_postgres.entities")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // mvn clean install mvn spring-boot:run -pl application
    }

}
