package com.review.review1.model;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person {
    private Set<Pet> petSet = new HashSet<>();

    public Set<Pet> getPetSet() {
        return petSet;
    }

    public void setPetSet(Set<Pet> petSet) {
        this.petSet = petSet;
    }
}
