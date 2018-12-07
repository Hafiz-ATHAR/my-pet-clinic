package com.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springframework.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
}
