package com.fmkbook.springbootbackend.services;

import com.fmkbook.springbootbackend.models.Bilet;
import com.fmkbook.springbootbackend.models.Miejsce;
import com.fmkbook.springbootbackend.models.Rezerwacja;
import com.fmkbook.springbootbackend.repositories.BiletRepository;
import com.fmkbook.springbootbackend.repositories.MiejsceRepository;
import com.fmkbook.springbootbackend.repositories.RezerwacjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BiletService {

    private final BiletRepository biletRepository;
    private final RezerwacjaRepository rezerwacjaRepository;
    private final MiejsceRepository miejsceRepository;

    @Autowired
    public BiletService(BiletRepository biletRepository,
                        RezerwacjaRepository rezerwacjaRepository,
                        MiejsceRepository miejsceRepository) {
        this.biletRepository = biletRepository;
        this.rezerwacjaRepository = rezerwacjaRepository;
        this.miejsceRepository = miejsceRepository;
    }

    public List<Bilet> getAllBilets() {
        return biletRepository.findAll();
    }

    public List<Bilet> getAllBiletsInRezerwacja(Integer rezerwacjaId) {
        Optional<Rezerwacja> rezerwacja = this.rezerwacjaRepository.findById(rezerwacjaId);
        if (rezerwacja.isEmpty()) {
            return null;
        }
        return biletRepository.findAllByRezerwacjaidrezerwacjiId(rezerwacja.get().getId());
    }

    public Bilet addBiletWithRezerwacjaAndMiejsce(Bilet bilet, Integer miejsceId, Integer rezererwacjaId) {
        Optional<Rezerwacja> foundRezerwacja = this.rezerwacjaRepository.findById(rezererwacjaId);
        if (foundRezerwacja.isEmpty()) {
            return null;
        }
        Optional<Miejsce> foundMiejsce = this.miejsceRepository.findById(miejsceId);
        if (foundMiejsce.isEmpty()) {
            return null;
        }
        //update sum
        foundRezerwacja.get().setCenarezerwacji(foundRezerwacja.get().getCenarezerwacji() + bilet.getCenabiletu());

        this.rezerwacjaRepository.save(foundRezerwacja.get());

        bilet.setRezerwacjaidrezerwacji(foundRezerwacja.get());
        bilet.setMiejsceidmiejsca(foundMiejsce.get());
        return this.biletRepository.save(bilet);
    }

    public Optional<Bilet> getBiletById(Integer id) {
        return biletRepository.findById(id);
    }

    public Bilet addBilet(Bilet bilet) {
        return biletRepository.save(bilet);
    }

    public Bilet updateBilet(Bilet bilet) {
        return biletRepository.save(bilet);
    }

    public void deleteBiletById(Integer id) {
        biletRepository.deleteById(id);
    }
}