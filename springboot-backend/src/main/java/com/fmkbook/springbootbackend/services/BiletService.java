package com.fmkbook.springbootbackend.services;

import com.fmkbook.springbootbackend.models.Bilet;
import com.fmkbook.springbootbackend.repositories.BiletRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BiletService {

    private final BiletRepository biletRepository;

    public BiletService(BiletRepository biletRepository) {
        this.biletRepository = biletRepository;
    }

    public List<Bilet> getAllBilets() {
        return biletRepository.findAll();
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