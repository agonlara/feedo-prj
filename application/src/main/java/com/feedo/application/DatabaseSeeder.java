package com.feedo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
public class DatabaseSeeder {


    @Autowired
    public DatabaseSeeder() {
        this.seedDatabase();
    }

    private void seedDatabase() {

    }
}
