package com.fmkbook.springbootbackend.services;


import com.fmkbook.springbootbackend.exception.UserNotFoundException;
import com.fmkbook.springbootbackend.models.Abonament;
import com.fmkbook.springbootbackend.models.Agent;
import com.fmkbook.springbootbackend.repositories.AbonamentRepository;
import com.fmkbook.springbootbackend.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AbonamentService {
    private final AbonamentRepository abonamentRepository;

    @Autowired
    public AbonamentService(AbonamentRepository abonamentRepository) {
        this.abonamentRepository = abonamentRepository;
    }

    public Abonament addAbonament(Abonament abonament){
        return this.abonamentRepository.save(abonament);
    }

    public List<Abonament> findAllAbonaments() {
        return this.abonamentRepository.findAll();
    }

    public Abonament updateAbonament(Abonament abonament) {
        return abonamentRepository.save(abonament);
    }

    public Abonament findAbonamentById(Integer id) {
        return abonamentRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found")); //change this later
    }

    public void deleteAbonament(Integer id){
        abonamentRepository.deleteById(id);
    }
}
