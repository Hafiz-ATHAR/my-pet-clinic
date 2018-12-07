package com.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springframework.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{
}
