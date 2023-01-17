package com.fmkbook.springbootbackend.services;

import com.fmkbook.springbootbackend.exception.UserNotFoundException;
import com.fmkbook.springbootbackend.models.Abonament;
import com.fmkbook.springbootbackend.models.Seans;
import com.fmkbook.springbootbackend.repositories.SeansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SeansService {
    private final SeansRepository seansRepository;

    @Autowired
    public SeansService(SeansRepository seansRepository) {
        this.seansRepository = seansRepository;
    }

    public Seans addSeans(Seans seans){
        return this.seansRepository.save(seans);
    }

    public List<Seans> findAllSeans() {
        return this.seansRepository.findAll();
    }

    public Seans findSeansById(Integer id) {
        return this.seansRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found")); //change this later
    }

    public void deleteSeans(Integer id){
        this.seansRepository.deleteById(id);
    }
}
