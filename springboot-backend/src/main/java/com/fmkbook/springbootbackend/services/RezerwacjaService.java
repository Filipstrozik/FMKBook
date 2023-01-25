package com.fmkbook.springbootbackend.services;

import com.fmkbook.springbootbackend.models.Rabat;
import com.fmkbook.springbootbackend.models.Rezerwacja;
import com.fmkbook.springbootbackend.repositories.RabatRepository;
import com.fmkbook.springbootbackend.models.*;
import com.fmkbook.springbootbackend.repositories.RezerwacjaRepository;
import com.fmkbook.springbootbackend.repositories.SeansRepository;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RezerwacjaService {
    private final RezerwacjaRepository rezerwacjaRepository;
    private final RabatRepository rabatRepository;
    private final SeansRepository seansRepository;

    @Autowired
    public RezerwacjaService(RezerwacjaRepository rezerwacjaRepository, RabatRepository rabatRepository, SeansRepository seansRepository) {
        this.rezerwacjaRepository = rezerwacjaRepository;
        this.rabatRepository = rabatRepository;
        this.seansRepository = seansRepository;
    }

    public List<Rezerwacja> getAllRezerwacjas() {
        return rezerwacjaRepository.findAll();
    }

    public List<Rezerwacja> getReservationsByDate(LocalDate startDate, LocalDate endDate) {
        List<Rezerwacja> reservations = new ArrayList<>();

        for (Rezerwacja rezerwacja : rezerwacjaRepository.findAll()) {
            if (rezerwacja.getSeansidseansu() != null
                    && rezerwacja.getSeansidseansu().getData() != null
                    && rezerwacja.getSeansidseansu().getData().isAfter(startDate)
                    && rezerwacja.getSeansidseansu().getData().isBefore(endDate)) {
                reservations.add(rezerwacja);
            }
        }
        return reservations;
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
        Seans seans1 = new Seans(LocalDate.of(2023, 1, 25), 39.23, LocalTime.of(1,2,30));
        Seans seans2 = new Seans(LocalDate.of(2023, 1, 27), 39.23, LocalTime.of(1,2,30));
        Seans seans3 = new Seans(LocalDate.of(2023, 1, 28), 39.23, LocalTime.of(1,2,30));
        Seans seans4 = new Seans(LocalDate.of(2023, 1, 29), 39.23, LocalTime.of(1,2,30));
        Seans seans5 = new Seans(LocalDate.of(2023, 1, 30), 39.23, LocalTime.of(1,2,30));

        seansRepository.save(seans1);
        seansRepository.save(seans2);
        seansRepository.save(seans3);
        seansRepository.save(seans4);
        seansRepository.save(seans5);

        Sposobplatnosci sposobplatnosci1 = new Sposobplatnosci("blik");
        Sposobplatnosci sposobplatnosci2 = new Sposobplatnosci("google pay");
        Sposobplatnosci sposobplatnosci3 = new Sposobplatnosci("apple pay");
        Sposobplatnosci sposobplatnosci4 = new Sposobplatnosci("karta");
        Sposobplatnosci sposobplatnosci5 = new Sposobplatnosci("paypal");
        Rezerwacja rezerwacja1 = new Rezerwacja(1, sposobplatnosci1, seans1);
        Rezerwacja rezerwacja2 = new Rezerwacja(2, sposobplatnosci3, seans1);
        Rezerwacja rezerwacja3 = new Rezerwacja(3, sposobplatnosci1, seans1);
        Rezerwacja rezerwacja4 = new Rezerwacja(4, sposobplatnosci2, seans2);
        Rezerwacja rezerwacja5 = new Rezerwacja(5, sposobplatnosci1, seans3);
        Rezerwacja rezerwacja6 = new Rezerwacja(6, sposobplatnosci1, seans4);
        Rezerwacja rezerwacja7 = new Rezerwacja(7, sposobplatnosci2, seans4);
        Rezerwacja rezerwacja8 = new Rezerwacja(8, sposobplatnosci1, seans4);
        Rezerwacja rezerwacja9 = new Rezerwacja(9, sposobplatnosci1, seans5);
        Rezerwacja rezerwacja10 = new Rezerwacja(10, sposobplatnosci1, seans3);
        Rezerwacja rezerwacja11 = new Rezerwacja(11, sposobplatnosci4, seans2);
        Rezerwacja rezerwacja12 = new Rezerwacja(12, sposobplatnosci5, seans5);
        Rezerwacja rezerwacja13 = new Rezerwacja(13, sposobplatnosci2, seans4);
        Rezerwacja rezerwacja14 = new Rezerwacja(14, sposobplatnosci5, seans3);
        Rezerwacja rezerwacja15 = new Rezerwacja(15, sposobplatnosci3, seans2);

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
