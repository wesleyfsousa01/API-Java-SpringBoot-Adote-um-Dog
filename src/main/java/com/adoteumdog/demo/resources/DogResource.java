package com.adoteumdog.demo.resources;

import com.adoteumdog.demo.entities.Dog;
import com.adoteumdog.demo.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Dog> insert(@RequestBody Dog obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
