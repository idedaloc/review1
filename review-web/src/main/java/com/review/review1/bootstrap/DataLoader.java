package com.review.review1.bootstrap;

import com.review.review1.model.Owner;
import com.review.review1.model.Vet;
import com.review.review1.services.OwnerService;
import com.review.review1.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("First");
        owner1.setLastName("Second");

        ownerService.save(owner1);

        System.out.println("Loading Services...");
        Vet vet1 = new Vet();
        vet1.setFirstName("First");
        vet1.setLastName("Second");

        vetService.save(vet1);

        System.out.println("Loading Vets...");
    }
}
