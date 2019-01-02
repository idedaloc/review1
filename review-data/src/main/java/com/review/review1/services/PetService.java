package com.review.review1.services;

import com.review.review1.model.Owner;
import com.review.review1.model.Pet;

import java.util.Optional;
import java.util.Set;

public interface PetService extends CrudService<Pet,Long> {

    Optional<Pet> findById(Long Id);
    Pet save(Pet pet);
    Set<Pet> findAll();
    
}
