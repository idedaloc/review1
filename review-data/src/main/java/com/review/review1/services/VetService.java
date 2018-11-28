package com.review.review1.services;

import com.review.review1.model.Owner;
import com.review.review1.model.Pet;
import com.review.review1.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long Id);
    Vet save(Vet vet);
    Set<Vet> findAll();
    
}
