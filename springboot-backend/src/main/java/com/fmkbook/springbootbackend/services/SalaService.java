package com.fmkbook.springbootbackend.services;

import com.fmkbook.springbootbackend.models.Sala;
import com.fmkbook.springbootbackend.repositories.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public List<Sala> getAllSalas() {
        return salaRepository.findAll();
    }

    public Optional<Sala> getSalaById(Integer id) {
        return salaRepository.findById(id);
    }

    public Sala addSala(Sala sala) {
        return salaRepository.save(sala);
    }

    public Sala updateSala(Sala sala) {
        return salaRepository.save(sala);
    }

    public void deleteSalaById(Integer id) {
        salaRepository.deleteById(id);
    }
}
