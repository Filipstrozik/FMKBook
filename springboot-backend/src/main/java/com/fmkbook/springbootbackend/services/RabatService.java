package com.fmkbook.springbootbackend.services;


import com.fmkbook.springbootbackend.exception.UserNotFoundException;
import com.fmkbook.springbootbackend.models.Rabat;
import com.fmkbook.springbootbackend.models.Uzytkownik;
import com.fmkbook.springbootbackend.repositories.RabatRepository;
import com.fmkbook.springbootbackend.repositories.UzytkownikRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class RabatService {
    private final RabatRepository rabatRepository;
    private final UzytkownikRepository uzytkownikRepository;

    public RabatService(RabatRepository rabatRepository, UzytkownikRepository uzytkownikRepository) {
        this.rabatRepository = rabatRepository;
        this.uzytkownikRepository = uzytkownikRepository;
    }

    public Rabat addRabat(Rabat rabat) {
        return this.rabatRepository.save(rabat);
    }

    public List<Rabat> findAllRabats() {
        return this.rabatRepository.findAll();
    }

    public boolean updateRabat(Integer idUser, String idRabatu) {
        Optional<Rabat> rabat = rabatRepository.findRabatById(idRabatu);
        Optional<Uzytkownik> uzytkownik = uzytkownikRepository.findUzytkownikById(idUser);
        if (rabat.isPresent() && uzytkownik.isPresent() && rabat.get().getUzytkownikiduzytkownika() == null) {
            rabat.get().setUzytkownikiduzytkownika(uzytkownik.get());
            rabatRepository.save(rabat.get());
            return true;
        }
        return false;
    }

    public Rabat findRabatById(String code) {
        return rabatRepository.findRabatById(code)
                .orElseThrow(() -> new UserNotFoundException("User by id " + code + " was not found"));
    }

    public void deleteRabat(String code) {
        rabatRepository.deleteRabatById(code);
    }
}
