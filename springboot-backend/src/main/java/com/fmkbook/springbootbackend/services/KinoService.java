package com.fmkbook.springbootbackend.services;

import com.fmkbook.springbootbackend.exception.UserNotFoundException;
import com.fmkbook.springbootbackend.models.Kino;
import com.fmkbook.springbootbackend.repositories.KinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class KinoService {

    private final KinoRepository kinoRepository;

    @Autowired

    public KinoService(KinoRepository kinoRepository) {
        this.kinoRepository = kinoRepository;
    }

    public Kino addKino(Kino kino){
        return this.kinoRepository.save(kino);
    }

    public List<Kino> getAllKino() {
        return this.kinoRepository.findAll();
    }

    public Kino getKinoById(Integer id) {
        return this.kinoRepository.findKinoById(id).orElseThrow(() -> new UserNotFoundException("Kino by id " + id + " was not found"));
    }

    public Kino updateKino(Kino kino) {
        return kinoRepository.save(kino);
    }

    public void deleteKinoById(Integer id) {
        kinoRepository.deleteById(id);
    }


}
