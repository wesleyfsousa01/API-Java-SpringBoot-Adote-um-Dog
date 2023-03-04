package com.adoteumdog.demo.services;

import com.adoteumdog.demo.entities.Dog;
import com.adoteumdog.demo.services.exceptions.ResourceNotFoundException;
import com.adoteumdog.demo.repositories.DogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
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

    public List<Dog> findAllAdopted(){
        return repository.findByIsAdoptedTrue();
    }

    public List<Dog> findAllNotAdopted(){
        return repository.findByIsAdoptedFalse();
    }
    public Dog insert(String dogJson, MultipartFile foto) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Dog dog = objectMapper.readValue(dogJson, Dog.class);
        dog.setAdopted(false);
        if(dog.getName().isBlank()){
            dog.setName("Ainda não possui um nome");
        }
        dog.setPhoto(foto.getBytes());

        //Verifica se o códgo gerado já existe, e gera um novo caso exista
        do {
            dog.setDogCode(Instant.now().toEpochMilli());
        }
        while (repository.findBydogCode(dog.getDogCode()) != null);

        return repository.save(dog);
    }
    public Dog updateIsAdopted(Long id) {
        Dog dog = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        dog.setAdopted(!dog.getAdopted());
        return repository.save(dog);
    }
}

