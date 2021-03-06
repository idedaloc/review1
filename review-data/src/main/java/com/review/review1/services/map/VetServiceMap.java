package com.review.review1.services.map;

import com.review.review1.model.Vet;
import com.review.review1.services.CrudService;
import com.review.review1.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@Profile({"default","map"})
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object);
    }

    @Override
    public Optional<Vet> findById(Long id) {
        return super.findById(id);
    }
}
