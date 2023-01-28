package com.fmkbook.springbootbackend.services;

import com.fmkbook.springbootbackend.models.Bilet;
import com.fmkbook.springbootbackend.models.Miejsce;
import com.fmkbook.springbootbackend.models.Rezerwacja;
import com.fmkbook.springbootbackend.repositories.BiletRepository;
import com.fmkbook.springbootbackend.repositories.MiejsceRepository;
import com.fmkbook.springbootbackend.repositories.RezerwacjaRepository;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class BiletServiceTest {
    @Autowired
    private BiletRepository biletRepository;
    private BiletService underTest;
    @Autowired
    private RezerwacjaRepository rezerwacjaRepository;
    @Autowired
    private MiejsceRepository miejsceRepository;

    private Bilet biletAlwaysNewBlankInstance;


    @BeforeEach
    void setUp() {
        underTest = new BiletService(biletRepository, rezerwacjaRepository, miejsceRepository);
        biletAlwaysNewBlankInstance = new Bilet();
    }

    @Test
    void addBiletWithRezerwacjaAndMiejsce() {
        Rezerwacja rezerwacja = new Rezerwacja();
        rezerwacja = rezerwacjaRepository.save(rezerwacja);

        Miejsce miejsce = new Miejsce();
        miejsce = miejsceRepository.save(miejsce);

        // Add the bilet with the rezerwacja and miejsce
        Bilet addedBilet = underTest.addBiletWithRezerwacjaAndMiejsce(biletAlwaysNewBlankInstance, miejsce.getId(), rezerwacja.getId());

        // Assert that the bilet was added successfully
        assertNotNull(addedBilet);
        assertEquals(11.99, addedBilet.getCenabiletu());
        assertEquals(rezerwacja, addedBilet.getRezerwacjaidrezerwacji());
        assertEquals(miejsce, addedBilet.getMiejsceidmiejsca());

        // Assert that the rezerwacja's sum was updated correctly
        assertEquals(11.99, rezerwacjaRepository.findById(rezerwacja.getId()).get().getCenarezerwacji());
    }

    @Test
    void addTwoBiletWithRezerwacjaAndMiejsce() {
        Rezerwacja rezerwacja = new Rezerwacja();
        rezerwacja = rezerwacjaRepository.save(rezerwacja);

        Miejsce miejsce = new Miejsce();
        miejsce = miejsceRepository.save(miejsce);

        // Add the bilet with the rezerwacja and miejsce
        Bilet addedBiletOne = underTest.addBiletWithRezerwacjaAndMiejsce(biletAlwaysNewBlankInstance, miejsce.getId(), rezerwacja.getId());
        Bilet addedBiletTwo = underTest.addBiletWithRezerwacjaAndMiejsce(biletAlwaysNewBlankInstance, miejsce.getId(), rezerwacja.getId());


        // Assert that the bilet was added successfully
        assertNotNull(addedBiletOne);
        assertNotNull(addedBiletTwo);

        // Assert that the rezerwacja's sum was updated correctly
        assertEquals(23.98, rezerwacjaRepository.findById(rezerwacja.getId()).get().getCenarezerwacji());
    }

    @Test
    void addBiletWithRezerwacjaAndMiejsce_NegativePrice() {
        Rezerwacja rezerwacja = new Rezerwacja();
        rezerwacja.setCenarezerwacji(100.00);
        rezerwacja = rezerwacjaRepository.save(rezerwacja);

        Miejsce miejsce = new Miejsce();
        miejsce = miejsceRepository.save(miejsce);

        // Add the bilet with the rezerwacja and miejsce
        Bilet addedBilet = underTest.addBiletWithRezerwacjaAndMiejsce(biletAlwaysNewBlankInstance, miejsce.getId(), rezerwacja.getId());

        // Assert that the bilet was not added successfully
        assertNotNull(addedBilet);
        assertEquals(11.99, addedBilet.getCenabiletu());
        assertEquals(rezerwacja, addedBilet.getRezerwacjaidrezerwacji());
        // Assert that the rezerwacja's sum was not updated
        assertEquals(111.99, rezerwacjaRepository.findById(rezerwacja.getId()).get().getCenarezerwacji());
    }

    @Test
    void addBiletWithRezerwacjaAndMiejsce_RezerwacjaNotFound() {

        Miejsce miejsce = new Miejsce();
        miejsce = miejsceRepository.save(miejsce);

        // Add the bilet with the rezerwacja and miejsce
        Bilet addedBilet = underTest.addBiletWithRezerwacjaAndMiejsce(biletAlwaysNewBlankInstance, miejsce.getId(), -1);

        // Assert that the bilet was not added successfully
        assertNull(addedBilet);
    }

    @Test
    void addBiletWithRezerwacjaAndMiejsce_MiejsceNotFound() {

        Rezerwacja rezerwacja = new Rezerwacja();
        rezerwacja = rezerwacjaRepository.save(rezerwacja);

        // Add the bilet with the rezerwacja and miejsce
        Bilet addedBilet = underTest.addBiletWithRezerwacjaAndMiejsce(biletAlwaysNewBlankInstance, -1, rezerwacja.getId());

        // Assert that the bilet was not added successfully
        assertNull(addedBilet);
    }

    @Test
    void addBiletWithRezerwacjaAndMiejsce_MiejsceAndRezerwacjaNotFound() {
        // Add the bilet with the rezerwacja and miejsce
        Bilet addedBilet = underTest.addBiletWithRezerwacjaAndMiejsce(biletAlwaysNewBlankInstance, -1, -1);
        // Assert that the bilet was not added successfully
        assertNull(addedBilet);
    }






}