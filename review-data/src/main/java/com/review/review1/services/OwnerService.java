package com.review.review1.services;

import com.review.review1.model.Owner;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface OwnerService extends  CrudService<Owner,Long>{

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
    Optional<Owner> findById(Long Id);
    Owner save(Owner owner);
    Set<Owner> findAll();

}
