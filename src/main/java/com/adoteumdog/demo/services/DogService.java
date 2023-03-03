package com.adoteumdog.demo.services;

import com.adoteumdog.demo.entities.Dog;
import com.adoteumdog.demo.services.exceptions.ResourceNotFoundException;
import com.adoteumdog.demo.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.UnexpectedTypeException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public Dog insert(Dog obj){
        if(obj.getNome() ==  null){
            obj.setNome("Ainda não possui um nome");
        }
        obj.setAdotado(false);
        return repository.save(obj);
    }
    public Dog updateIsAdotado(Long id) {
        Dog dog = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        dog.setAdotado(!dog.getAdotado());
        return repository.save(dog);
    }

    public List<Dog> findAllAdopted(){
        return repository.findByIsAdotadoTrue();
    }

    public List<Dog> findAllNotAdopted(){
        return repository.findByIsAdotadoFalse();
    }

}

