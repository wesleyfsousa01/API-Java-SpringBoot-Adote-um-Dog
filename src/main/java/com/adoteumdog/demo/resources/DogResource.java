package com.adoteumdog.demo.resources;

import com.adoteumdog.demo.entities.Dog;
import com.adoteumdog.demo.services.DogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/dogs")
public class DogResource {
    @Autowired
    private DogService service;
    @GetMapping
    public ResponseEntity<List<Dog>> findAll(){
        List<Dog> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Dog> findById(@PathVariable Long id){
        Dog obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping("/adopted")
    public List<Dog> findAllAdopted(){
        return service.findAllAdopted();
    }

    @GetMapping("/notadopted")
    public List<Dog> findAllNotAdopted(){
        return service.findAllNotAdopted();
    }

    @PostMapping("/savedog")
    public ResponseEntity<Dog> save(@RequestParam("dog") String dog, @RequestParam ("foto") MultipartFile foto) throws IOException {
        Dog dogSaved = service.insert(dog, foto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dogSaved.getId()).toUri();
        return ResponseEntity.created(uri).body(dogSaved);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateIsAdotado(@PathVariable("id") Long id) {
        Dog updatedDog = service.updateIsAdopted(id);
        return ResponseEntity.ok(updatedDog);
    }

}
