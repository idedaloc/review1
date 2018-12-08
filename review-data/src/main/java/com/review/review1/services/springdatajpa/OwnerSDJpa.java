package com.review.review1.services.springdatajpa;

import com.review.review1.model.Owner;
import com.review.review1.repositories.OwnerRepository;
import com.review.review1.repositories.PetRepository;
import com.review.review1.repositories.PetTypeRepository;
import com.review.review1.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpa implements OwnerService {

    private OwnerRepository ownerRepository;
    private PetRepository petRepository;
    private PetTypeRepository petTypeRepository;

    public OwnerSDJpa(OwnerRepository ownerRepository, PetRepository petRepository,
                      PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findById(Long Id) {
        return ownerRepository.findById(Id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Owner save(Owner owner) {
        System.out.println("***************************************");
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;

    }
}
