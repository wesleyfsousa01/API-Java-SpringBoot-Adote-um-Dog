package com.adoteumdog.demo.config;

import com.adoteumdog.demo.entities.Dog;
import com.adoteumdog.demo.repositories.DogRepository;
import com.adoteumdog.demo.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DevConfig implements CommandLineRunner {

    @Autowired
    private DogService dogService;


    @Override
    public void run(String... args) throws Exception {


        Dog cao = new Dog(null,null,"Pinscher",18,"Malhado",
                "Pinscher 1",true,1,
                "889933232","Igor",null);
        dogService.insert(cao);
    }
}
