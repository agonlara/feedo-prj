package com.feedo.back.application;

import com.feedo.back.domain.model.*;
import com.feedo.back.domain.ports.CommandPersistencePort;
import com.feedo.back.domain.ports.TablePersistencePort;
import com.feedo.back.infraestructure.persistence_mongodb.entities.CommandDocument;
import com.feedo.back.infraestructure.persistence_mongodb.entities.ProductDocument;
import com.feedo.back.infraestructure.persistence_mongodb.entities.RestaurantDocument;
import com.feedo.back.infraestructure.persistence_mongodb.entities.TableDocument;
import com.feedo.back.infraestructure.persistence_mongodb.repositories.CommandRepository;
import com.feedo.back.infraestructure.persistence_mongodb.repositories.ProductRepository;
import com.feedo.back.infraestructure.persistence_mongodb.repositories.RestaurantRepository;
import com.feedo.back.infraestructure.persistence_mongodb.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.feedo.back.domain.model.ProductCategory.*;
import static com.feedo.back.domain.model.TableType.*;

@Profile({"dev", "default"})
@Component
public class DatabaseSeeder {

    private final CommandRepository commandRepository;
    private final RestaurantRepository restaurantRepository;
    private final TableRepository tableRepository;
    private final ProductRepository productRepository;

    @Autowired
    public DatabaseSeeder(CommandRepository commandRepository,
                          RestaurantRepository restaurantRepository,
                          TableRepository tableRepository,
                          ProductRepository productRepository) {
        this.commandRepository = commandRepository;
        this.restaurantRepository = restaurantRepository;
        this.tableRepository = tableRepository;
        this.productRepository = productRepository;
        this.seedDatabase();
    }

    private void seedDatabase() {
        Product p1 = Product.builder() .id("1").name("coca").available(true).price(100f).categories(Collections.singletonList(ADULT)).build();
        Product p2 = Product.builder() .id("2").name("bocata").available(true).price(80f).categories(Collections.singletonList(FOOD)).build();
        Product p3 = Product.builder() .id("3").name("bravas").available(true).price(3.3f).categories(Collections.singletonList(FOOD)).build();
        Product p4 = Product.builder() .id("4").name("tabac").available(false).price(40f).categories(Collections.singletonList(ADULT)).build();
        Product p5 = Product.builder() .id("5").name("suc").available(true).price(20.5f).categories(Collections.singletonList(DRINK)).build();
        List<ProductDocument> products = Stream.of(p1, p2, p3, p4, p5).map(ProductDocument::new).collect(Collectors.toList());
        productRepository.saveAll(products);

        Restaurant r1 = Restaurant.builder().id("1").name("Restaurant manel").products(Arrays.asList(p1, p2, p3)).build();
        Restaurant r2 = Restaurant.builder().id("3").name("Restaurant shinatowNNN").products(Arrays.asList(p1, p4, p5)).build();
        List<RestaurantDocument> restaurants = Stream.of(r1, r2).map(RestaurantDocument::new).collect(Collectors.toList());
        restaurantRepository.saveAll(restaurants);

        Table t1 = Table.builder().id("1").restaurant(r1).type(INSIDE).build();
        Table t2 = Table.builder().id("2").restaurant(r1).type(INSIDE).build();
        Table t3 = Table.builder().id("3").restaurant(r2).type(OUTSIDE).build();
        List<TableDocument> tables = Stream.of(t1, t2, t3).map(TableDocument::new).collect(Collectors.toList());
        tableRepository.saveAll(tables);

        Command c1 = Command.builder().id("1").table(t1).requestDate(LocalDateTime.now()).deliverd(true).deliveryDate(LocalDateTime.now()).products(Arrays.asList(p1)).build();
        Command c2 = Command.builder().id("2").table(t1).requestDate(LocalDateTime.now()).deliverd(false).products(Arrays.asList(p1, p2, p3, p4)).build();
        Command c3 = Command.builder().id("3").table(t1).requestDate(LocalDateTime.now()).deliverd(false).products(Arrays.asList(p2)).build();
        Command c4 = Command.builder().id("4").table(t3).requestDate(LocalDateTime.now()).deliverd(false).products(Arrays.asList(p3)).build();
        Command c5 = Command.builder().id("5").table(t3).requestDate(LocalDateTime.now()).deliverd(false).products(Arrays.asList(p4, p5)).build();
        List<CommandDocument> commands = Stream.of(c1, c2, c3, c4, c5).map(CommandDocument::new).collect(Collectors.toList());
        commandRepository.saveAll(commands);
    }
}
