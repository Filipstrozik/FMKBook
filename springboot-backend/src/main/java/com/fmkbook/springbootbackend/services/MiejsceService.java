package com.fmkbook.springbootbackend.services;

import com.fmkbook.springbootbackend.models.Miejsce;
import com.fmkbook.springbootbackend.repositories.MiejsceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MiejsceService {

    private final MiejsceRepository miejsceRepository;


    public MiejsceService(MiejsceRepository miejsceRepository) {
        this.miejsceRepository = miejsceRepository;
    }

    public List<Miejsce> getAllMiejsces() {
        return miejsceRepository.findAll();
    }

    public List<Miejsce> getAvailableMiejsce(Integer seansId) {
        return miejsceRepository.findFreeMiejsceBySeans(seansId);
    }

    public List<Miejsce> getAllMiejscesInSala(Integer salaId) {

        return miejsceRepository.findAllBySalaidsaliId(salaId);
    }

    public Optional<Miejsce> getMiejsceById(Integer id) {
        return miejsceRepository.findById(id);
    }

    public Miejsce addMiejsce(Miejsce miejsce) {
        return miejsceRepository.save(miejsce);
    }

    public Miejsce updateMiejsce(Miejsce miejsce) {
        return miejsceRepository.save(miejsce);
    }

    public void deleteMiejsceById(Integer id) {
        miejsceRepository.deleteById(id);
    }
}
