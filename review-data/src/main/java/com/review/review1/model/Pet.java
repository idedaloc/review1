package com.review.review1.model;

import lombok.*;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{
	
    private String name;

    @ManyToOne()
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne()
    @JoinColumn(name = "owner_id")
    private Owner owner;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birhtDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    @Builder
	public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birhtDate, Set<Visit> visits) {
		super(id);
		this.name = name;
		this.petType = petType;
		this.owner = owner;
		this.birhtDate = birhtDate;
		if(visits == null || !visits.isEmpty())
			this.visits = visits;
	}

    
    
    

}
