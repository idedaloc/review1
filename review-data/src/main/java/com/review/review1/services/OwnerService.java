package com.review.review1.services;

import com.review.review1.model.Owner;

import java.util.Set;

public interface OwnerService extends  CrudService<Owner,Long>{

    Owner findByLastName(String lastName);
    Owner findById(Long Id);
    Owner save(Owner owner);
    Set<Owner> findAll();

}
