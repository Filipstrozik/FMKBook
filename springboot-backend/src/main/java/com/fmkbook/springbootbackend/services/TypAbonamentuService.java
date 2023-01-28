package com.fmkbook.springbootbackend.services;

import com.fmkbook.springbootbackend.exception.UserNotFoundException;
import com.fmkbook.springbootbackend.models.Agent;
import com.fmkbook.springbootbackend.models.Rabat;
import com.fmkbook.springbootbackend.models.Typabonamentu;
import com.fmkbook.springbootbackend.models.Uzytkownik;
import com.fmkbook.springbootbackend.repositories.TypAbonamentuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TypAbonamentuService {
    private TypAbonamentuRepository typAbonamentuRepository;

    @Autowired
    public TypAbonamentuService(TypAbonamentuRepository typAbonamentuRepository) {
        this.typAbonamentuRepository = typAbonamentuRepository;
    }

    public Typabonamentu addTypAbonamentu(Typabonamentu typ){
        return this.typAbonamentuRepository.save(typ);
    }

    public Typabonamentu updateTypAbonamentu(Integer idTypuAbonamentu, Double nowaCena) {
        Optional<Typabonamentu> typ = this.typAbonamentuRepository.findTypabonamentuById(idTypuAbonamentu);
        if (typ.isPresent()) {
            typ.get().setCena(nowaCena);
            this.typAbonamentuRepository.save(typ.get());
            return typ.get();
        }
        return null;
    }

    public List<Typabonamentu> findAllTypAbonamentu() {
        return this.typAbonamentuRepository.findAll();
    }


    public Typabonamentu findAbonamentById(Integer id) {
        return this.typAbonamentuRepository.findTypabonamentuById(id)
                .orElseThrow(() -> new UserNotFoundException("Abonament by id " + id + " was not found"));
    }

    public void deleteTypAbonamentu(Integer id) {
        this.typAbonamentuRepository.deleteById(id);
    }
}
