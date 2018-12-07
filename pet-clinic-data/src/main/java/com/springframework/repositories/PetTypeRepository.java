package com.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springframework.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long>{
}
