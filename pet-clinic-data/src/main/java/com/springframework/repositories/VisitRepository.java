package com.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springframework.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long>{
}
