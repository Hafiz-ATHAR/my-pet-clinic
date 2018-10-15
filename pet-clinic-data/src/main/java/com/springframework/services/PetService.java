package com.springframework.services;

import java.util.Set;

import com.springframework.model.Pet;

public interface PetService {

	Pet findById(Long id);
	Pet save(Pet pet);
	Set<Pet> findAll();
}
