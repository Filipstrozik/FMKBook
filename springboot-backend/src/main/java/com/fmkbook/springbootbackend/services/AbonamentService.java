package com.fmkbook.springbootbackend.services;


import com.fmkbook.springbootbackend.exception.UserNotFoundException;
import com.fmkbook.springbootbackend.models.Abonament;
import com.fmkbook.springbootbackend.models.Agent;
import com.fmkbook.springbootbackend.models.Typabonamentu;
import com.fmkbook.springbootbackend.models.Uzytkownik;
import com.fmkbook.springbootbackend.repositories.AbonamentRepository;
import com.fmkbook.springbootbackend.repositories.AgentRepository;
import com.fmkbook.springbootbackend.repositories.TypAbonamentuRepository;
import com.fmkbook.springbootbackend.repositories.UzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AbonamentService {
    private final AbonamentRepository abonamentRepository;
    private final UzytkownikRepository uzytkownikRepository;
    private final TypAbonamentuRepository typAbonamentuRepository;

    @Autowired
    public AbonamentService(AbonamentRepository abonamentRepository, UzytkownikRepository uzytkownikRepository, TypAbonamentuRepository typAbonamentuRepository) {
        this.abonamentRepository = abonamentRepository;
        this.uzytkownikRepository = uzytkownikRepository;
        this.typAbonamentuRepository = typAbonamentuRepository;
    }


    public Abonament addAbonament(Abonament abonament){
        return this.abonamentRepository.save(abonament);
    }

    public List<Abonament> findAllAbonaments() {
        return this.abonamentRepository.findAll();
    }

    public Abonament updateAbonament(Integer idUser, Integer idTypAbonamentu) {
        Optional<Uzytkownik> user = this.uzytkownikRepository.findUzytkownikById(idUser);
        Optional<Typabonamentu> typabonamentu = this.typAbonamentuRepository.findTypabonamentuById(idTypAbonamentu);
        if(user.isPresent() && typabonamentu.isPresent()){
            Abonament newAbonament = new Abonament();
            newAbonament.setUzytkownikiduzytkownika(user.get());
            newAbonament.setTypabonamentucolumn(typabonamentu.get());
            return this.abonamentRepository.save(newAbonament);
        }
        return null;
    }

    public Abonament findAbonamentById(Integer id) {
        return abonamentRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found")); //change this later
    }

    public void deleteAbonament(Integer id){
        abonamentRepository.deleteById(id);
    }
}
