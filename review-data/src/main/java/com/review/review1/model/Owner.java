package com.review.review1.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner extends Person {
    @Column(name = "addres")
    private String address;
    private String city;
    private String telephone;
    private Set<Pet> petSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    public Set<Pet> getPetSet() {
        return petSet;
    }

    public void setPetSet(Set<Pet> petSet) {
        this.petSet = petSet;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
