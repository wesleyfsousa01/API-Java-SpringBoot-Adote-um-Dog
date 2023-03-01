package com.adoteumdog.demo.repositories;

import com.adoteumdog.demo.entities.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long>{

}
