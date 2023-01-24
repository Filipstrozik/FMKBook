package com.fmkbook.springbootbackend.services;

import com.fmkbook.springbootbackend.models.Rabat;
import com.fmkbook.springbootbackend.models.Rezerwacja;
import com.fmkbook.springbootbackend.repositories.RabatRepository;
import com.fmkbook.springbootbackend.models.*;
import com.fmkbook.springbootbackend.repositories.RezerwacjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RezerwacjaService {
    private final RezerwacjaRepository rezerwacjaRepository;
    private final RabatRepository rabatRepository;

    @Autowired
    public RezerwacjaService(RezerwacjaRepository rezerwacjaRepository, RabatRepository rabatRepository) {
        this.rezerwacjaRepository = rezerwacjaRepository;
        this.rabatRepository = rabatRepository;
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
            if (rabat.isPresent() && currentRezerwacja.getRabatkodrabatowy() == null) {
                currentRezerwacja.setRabatkodrabatowy(rabat.get());
                Double price = currentRezerwacja.getCenarezerwacji();
                Double discount = rabat.get().getWysokoscrabatu();
                currentRezerwacja.setCenarezerwacji(price - (price * discount / 100));
                return rezerwacjaRepository.save(currentRezerwacja);
            }
        }
        return currentRezerwacja;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void init() {
//        Uzytkownik uzytkownik1 = new Uzytkownik(1, "sdadsdas", "saddssdasdasd", "hghgfgfg");
//        Rabat rabat1 = new Rabat("1", 2.00);
//        Seans seans1 = new Seans(1, LocalDate.MIN, LocalTime.MAX, 39.23);
        Sposobplatnosci sposobplatnosci1 = new Sposobplatnosci("blik");
        Sposobplatnosci sposobplatnosci2 = new Sposobplatnosci("google pay");
        Sposobplatnosci sposobplatnosci3 = new Sposobplatnosci("apple pay");
        Sposobplatnosci sposobplatnosci4 = new Sposobplatnosci("karta");
        Sposobplatnosci sposobplatnosci5 = new Sposobplatnosci("paypal");
        Rezerwacja rezerwacja1 = new Rezerwacja(1, sposobplatnosci1);
        Rezerwacja rezerwacja2 = new Rezerwacja(2, sposobplatnosci3);
        Rezerwacja rezerwacja3 = new Rezerwacja(3, sposobplatnosci1);
        Rezerwacja rezerwacja4 = new Rezerwacja(4, sposobplatnosci2);
        Rezerwacja rezerwacja5 = new Rezerwacja(5, sposobplatnosci1);
        Rezerwacja rezerwacja6 = new Rezerwacja(6, sposobplatnosci1);
        Rezerwacja rezerwacja7 = new Rezerwacja(7, sposobplatnosci2);
        Rezerwacja rezerwacja8 = new Rezerwacja(8, sposobplatnosci1);
        Rezerwacja rezerwacja9 = new Rezerwacja(9, sposobplatnosci1);
        Rezerwacja rezerwacja10 = new Rezerwacja(10, sposobplatnosci1);
        Rezerwacja rezerwacja11 = new Rezerwacja(11, sposobplatnosci4);
        Rezerwacja rezerwacja12 = new Rezerwacja(12, sposobplatnosci5);
        Rezerwacja rezerwacja13 = new Rezerwacja(13, sposobplatnosci2);
        Rezerwacja rezerwacja14 = new Rezerwacja(14, sposobplatnosci5);
        Rezerwacja rezerwacja15 = new Rezerwacja(15, sposobplatnosci3);

        createRezerwacja(rezerwacja1);
        createRezerwacja(rezerwacja2);
        createRezerwacja(rezerwacja3);
        createRezerwacja(rezerwacja4);
        createRezerwacja(rezerwacja5);
        createRezerwacja(rezerwacja6);
        createRezerwacja(rezerwacja7);
        createRezerwacja(rezerwacja8);
        createRezerwacja(rezerwacja9);
        createRezerwacja(rezerwacja10);
        createRezerwacja(rezerwacja11);
        createRezerwacja(rezerwacja12);
        createRezerwacja(rezerwacja13);
        createRezerwacja(rezerwacja14);
        createRezerwacja(rezerwacja15);
    }
}
