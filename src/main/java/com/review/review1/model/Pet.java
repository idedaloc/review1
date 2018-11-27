package com.review.review1.model;

import sun.util.resources.LocaleData;

public class Pet {
    private PetType petType;
    private Owner owner;
    private LocaleData birhtDate;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocaleData getBirhtDate() {
        return birhtDate;
    }

    public void setBirhtDate(LocaleData birhtDate) {
        this.birhtDate = birhtDate;
    }
}
