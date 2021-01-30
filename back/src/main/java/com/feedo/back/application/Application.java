package com.feedo.back.application;

import com.feedo.back.infraestructure.persistence_mongodb.repositories.CommandRepository;
import com.feedo.back.infraestructure.persistence_mongodb.repositories.TableRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@EnableMongoRepositories(basePackageClasses = {
        CommandRepository.class,
        TableRepository.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
