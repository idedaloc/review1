package com.review.review1.services.map;

import com.review.review1.model.Owner;
import com.review.review1.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements CrudService<Owner,Long> {

    @Override
    public Set<Owner> findAll() {
        return this.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        this.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return this.save(object);
    }

    @Override
    public Owner findById(Long id) {
        return this.findById(id);
    }
}
