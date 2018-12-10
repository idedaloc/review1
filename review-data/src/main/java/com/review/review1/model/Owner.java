package com.review.review1.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {
    @Column(name = "addres")
    private String address;
    private String city;
    private String telephone;

    @Builder
    public Owner(Long id, String firstName, String lastName,
                 String address, String city, String telephone,
                 Set<Pet> petSet) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.petSet = petSet;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> petSet = new HashSet<>();

}
