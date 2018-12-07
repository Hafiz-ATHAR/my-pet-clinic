package com.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springframework.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long>{
}
