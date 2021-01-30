package com.feedo.back.application;

import com.feedo.back.domain.model.Restaurant;
import com.feedo.back.domain.ports.CommandPersistencePort;
import com.feedo.back.domain.ports.RestaurantPersistencePort;
import com.feedo.back.domain.ports.TablePersistencePort;
import com.feedo.back.domain.use_cases.command.CreateCommandUseCase;
import com.feedo.back.domain.use_cases.command.DeliverCommandUseCase;
import com.feedo.back.domain.use_cases.command.FindCommandsUseCase;
import com.feedo.back.domain.use_cases.command.impl.CommandServiceImpl;
import com.feedo.back.domain.use_cases.restaurant.FindRestaurantUseCase;
import com.feedo.back.domain.use_cases.restaurant.impl.RestaurantServiceImpl;
import com.feedo.back.domain.use_cases.table.FindTableUseCase;
import com.feedo.back.domain.use_cases.table.impl.TableServiceImpl;
import com.feedo.back.infraestructure.persistence_mongodb.adapters.CommandPersistenceMongodbAdapter;
import com.feedo.back.infraestructure.persistence_mongodb.adapters.RestaurantPersistenceMongodbAdapter;
import com.feedo.back.infraestructure.persistence_mongodb.adapters.TablePersistenceMongodbAdapter;
import com.feedo.back.infraestructure.persistence_mongodb.repositories.CommandRepository;
import com.feedo.back.infraestructure.persistence_mongodb.repositories.RestaurantRepository;
import com.feedo.back.infraestructure.persistence_mongodb.repositories.TableRepository;
import com.feedo.back.infraestructure.rest.RestaurantResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {
        RestaurantResource.class,
})
public class ApplicationConfiguration {

    @Bean
    public RestaurantPersistencePort restaurantPersistencePort(RestaurantRepository restaurantRepository) {
        return new RestaurantPersistenceMongodbAdapter(restaurantRepository);
    }

    @Bean
    public CommandPersistencePort commandPersistencePort(CommandRepository commandRepository) {
        return new CommandPersistenceMongodbAdapter(commandRepository);
    }

    @Bean
    public TablePersistencePort tablePersistencePort(TableRepository tableRepository) {
        return new TablePersistenceMongodbAdapter(tableRepository);
    }

    @Bean
    public FindRestaurantUseCase findRestaurantUseCase(RestaurantPersistencePort restaurantPersistencePort) {
        return new RestaurantServiceImpl(restaurantPersistencePort);
    }

    @Bean
    public FindTableUseCase findTableUseCase(TablePersistencePort tablePersistencePort) {
        return new TableServiceImpl(tablePersistencePort);
    }

    @Bean
    public CreateCommandUseCase createCommandUseCase(CommandPersistencePort commandPersistencePort) {
        return new CommandServiceImpl(commandPersistencePort);
    }

    @Bean
    public DeliverCommandUseCase deliverCommandUseCase(CommandPersistencePort commandPersistencePort) {
        return new CommandServiceImpl(commandPersistencePort);
    }

    @Bean
    public FindCommandsUseCase findCommandsUseCase(CommandPersistencePort commandPersistencePort) {
        return new CommandServiceImpl(commandPersistencePort);
    }

}
