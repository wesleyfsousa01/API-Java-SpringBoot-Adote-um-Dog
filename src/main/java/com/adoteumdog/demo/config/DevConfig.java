package com.adoteumdog.demo.config;

import com.adoteumdog.demo.entities.Dog;
import com.adoteumdog.demo.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DevConfig implements CommandLineRunner {

    @Autowired
    private DogRepository dogRepository;


    @Override
    public void run(String... args) throws Exception {
        Dog cao = new Dog(null,"Apollo","Pinscher",18,"Malhado",
                "Pinscher 1",true,1,false,
                "889933232","Igor",null);
        dogRepository.save(cao);
    }
}
