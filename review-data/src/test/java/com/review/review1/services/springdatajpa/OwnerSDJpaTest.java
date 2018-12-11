package com.review.review1.services.springdatajpa;

import com.review.review1.model.Owner;
import com.review.review1.repositories.OwnerRepository;
import com.review.review1.repositories.PetRepository;
import com.review.review1.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaTest {

    @Mock
    private OwnerRepository ownerRepository;
    @Mock
    private PetRepository petRepository;
    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    private OwnerSDJpa ownerSDJpa;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        //given
        Owner r = Owner.builder().id(1L).lastName("Last").build();

        //when
        when(ownerSDJpa.findByLastName(any())).thenReturn(r);
        Owner s =  ownerSDJpa.findByLastName("Last");

        //then

        assertEquals(r.getLastName(), s.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findAll() {
    }
}