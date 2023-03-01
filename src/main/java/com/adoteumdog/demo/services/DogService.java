package com.adoteumdog.demo.services;

import com.adoteumdog.demo.entities.Dog;
import com.adoteumdog.demo.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {
    @Autowired
    private DogRepository repository;

    public List<Dog> findAll(){
        return repository.findAll();
    }

    public Dog findById(Long id){
        Optional<Dog> obj = repository.findById(id);
        return obj.get();
    }
    public Dog insert(Dog obj){
        return repository.save(obj);
    }
}
