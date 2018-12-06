package com.review.review1.services.map;

import com.review.review1.model.Owner;
import com.review.review1.model.Pet;
import com.review.review1.services.CrudService;
import com.review.review1.services.OwnerService;
import com.review.review1.services.PetService;
import com.review.review1.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if(object == null)
            throw new RuntimeException("Pet Type is requiered");
        if(object.getPetSet() != null){

            object.getPetSet().forEach(

                    pet -> {
                        if(pet.getPetType() != null ){
                            if(pet.getPetType().getId() != null)
                                pet.setPetType(petTypeService.save(pet.getPetType()));
                        }

                        if(pet.getId() != null){
                            Pet savedPate = petService.save(pet);
                            pet.setId(savedPate.getId());
                        }


                    });

        }

        return super.save(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
