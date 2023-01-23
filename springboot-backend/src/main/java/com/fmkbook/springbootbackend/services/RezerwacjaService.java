package com.fmkbook.springbootbackend.services;

import com.fmkbook.springbootbackend.models.Rabat;
import com.fmkbook.springbootbackend.models.Rezerwacja;
import com.fmkbook.springbootbackend.models.Seans;
import com.fmkbook.springbootbackend.models.Uzytkownik;
import com.fmkbook.springbootbackend.repositories.RabatRepository;
import com.fmkbook.springbootbackend.repositories.RezerwacjaRepository;
import com.fmkbook.springbootbackend.repositories.SeansRepository;
import com.fmkbook.springbootbackend.repositories.UzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RezerwacjaService {
    private final RezerwacjaRepository rezerwacjaRepository;
    private final RabatRepository rabatRepository;
    private final UzytkownikRepository uzytkownikRepository;
    private final SeansRepository seansRepository;


    public RezerwacjaService(RezerwacjaRepository rezerwacjaRepository, RabatRepository rabatRepository, UzytkownikRepository uzytkownikRepository, SeansRepository seansRepository) {
        this.rezerwacjaRepository = rezerwacjaRepository;
        this.rabatRepository = rabatRepository;
        this.uzytkownikRepository = uzytkownikRepository;
        this.seansRepository = seansRepository;
    }

    public List<Rezerwacja> getAllRezerwacjas() {
        return rezerwacjaRepository.findAll();
    }

    public Optional<Rezerwacja> getRezerwacjaById(Integer id) {
        return rezerwacjaRepository.findById(id);
    }

    public Rezerwacja createRezerwacja(Rezerwacja rezerwacja) {
        return rezerwacjaRepository.save(rezerwacja);
    }

    public Rezerwacja createRezerwacjaWithUser(Rezerwacja rezerwacja, Integer userId, Integer seansId) {
        Optional<Uzytkownik> foundUser = this.uzytkownikRepository.findUzytkownikById(userId);
        if (foundUser.isEmpty()){
            return null;
        }
        Optional<Seans> foundSeans = this.seansRepository.findById(seansId);
        if (foundSeans.isEmpty()){
            return null;
        }

        rezerwacja.setSeansidseansu(foundSeans.get());
        rezerwacja.setUzytkownikiduzytkownika(foundUser.get());
        return rezerwacjaRepository.save(rezerwacja);
    }


    public Rezerwacja updateRezerwacja(Integer id, Rezerwacja rezerwacja) {
        Rezerwacja currentRezerwacja = rezerwacjaRepository.findById(id).orElse(null);
        if (currentRezerwacja != null) {
            currentRezerwacja.setUzytkownikiduzytkownika(rezerwacja.getUzytkownikiduzytkownika());
            currentRezerwacja.setRabatkodrabatowy(rezerwacja.getRabatkodrabatowy());
            currentRezerwacja.setCenarezerwacji(rezerwacja.getCenarezerwacji());
            currentRezerwacja.setSeansidseansu(rezerwacja.getSeansidseansu());
            currentRezerwacja.setSposobplatnoscinazwametody(rezerwacja.getSposobplatnoscinazwametody());
            currentRezerwacja.setBilets(rezerwacja.getBilets());
            return rezerwacjaRepository.save(currentRezerwacja);
        } else {
            return null;
        }
    }

    public void deleteRezerwacja(Integer id) {
        rezerwacjaRepository.deleteById(id);
    }

    public Rezerwacja setRabat(Integer idRez, String idRabatu) {
        Rezerwacja currentRezerwacja = rezerwacjaRepository.findById(idRez).orElse(null);
        if (currentRezerwacja != null) {
            Optional<Rabat> rabat = rabatRepository.findRabatById(idRabatu);
            if(rabat.isPresent() && currentRezerwacja.getRabatkodrabatowy()==null){
                currentRezerwacja.setRabatkodrabatowy(rabat.get());
                Double price = currentRezerwacja.getCenarezerwacji();
                Double discount = rabat.get().getWysokoscrabatu();
                currentRezerwacja.setCenarezerwacji(price - (price*discount/100));
                return rezerwacjaRepository.save(currentRezerwacja);
            }
        }
        return currentRezerwacja;
    }
}
