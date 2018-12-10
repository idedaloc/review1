package com.review.review1.bootstrap;

import com.review.review1.model.Owner;
import com.review.review1.model.Pet;
import com.review.review1.model.PetType;
import com.review.review1.model.Vet;
import com.review.review1.services.OwnerService;
import com.review.review1.services.PetTypeService;
import com.review.review1.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("First");
        owner1.setLastName("Second");
        owner1.setAddress("123 addres");
        owner1.setCity("Miami");
        owner1.setTelephone("123345123");

        Owner testingOwner = Owner.builder().firstName("TestingBuilder").build();

        Pet firstsPet = new Pet();
        firstsPet.setName("FitstsPet");
        firstsPet.setOwner(owner1);
        firstsPet.setBirhtDate(LocalDate.now());
        firstsPet.setPetType(savedDogType);

        owner1.getPetSet().add(firstsPet);

        ownerService.save(owner1);

        System.out.println("Loading Services...");
        Vet vet1 = new Vet();
        vet1.setFirstName("First");
        vet1.setLastName("Second");

        vetService.save(vet1);

        System.out.println("Loading Vets...");
    }
}
