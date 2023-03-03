package com.adoteumdog.demo.repositories;

import com.adoteumdog.demo.entities.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long>{
    List<Dog> findByIsAdotadoTrue();
    List<Dog> findByIsAdotadoFalse();
}
