package com.fmkbook.springbootbackend.controllers;

import com.fmkbook.springbootbackend.models.Bilet;
import com.fmkbook.springbootbackend.models.Typbiletu;
import com.fmkbook.springbootbackend.models.Typmiejsca;
import com.fmkbook.springbootbackend.services.BiletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bilet")
public class BiletApi {
    private final BiletService biletService;

    public BiletApi(BiletService biletService) {
        this.biletService = biletService;
    }

    @GetMapping
    public ResponseEntity<List<Bilet>> getAllBilets() {
        return new ResponseEntity<>(biletService.getAllBilets(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bilet> getBiletById(@PathVariable Integer id) {
        Optional<Bilet> bilet = biletService.getBiletById(id);
        if (bilet.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bilet.get(), HttpStatus.OK);
    }

    @GetMapping("/rezerwacja/{id}")
    public ResponseEntity<List<Bilet>> getBiletByRezerwacjaId(@PathVariable Integer id) {
        return new ResponseEntity<>(biletService.getAllBiletsInRezerwacja(id), HttpStatus.OK);
    }

//    @GetMapping("/sala/{id}")
//    public ResponseEntity<List<Bilet>> getAllBilets(@PathVariable Integer salaId) {
//        return new ResponseEntity<>(biletService.getAllBiletsInSala(salaId), HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<Bilet> addBilet(@RequestBody Bilet bilet) {
        return new ResponseEntity<>(biletService.addBilet(bilet), HttpStatus.CREATED);
    }

    @PostMapping("/more")
    public ResponseEntity<Bilet> addBiletWithParams(@RequestBody Bilet bilet,
                                                    @RequestParam("miejsce") Integer miejsceId,
                                                    @RequestParam("rezerwacja") Integer rezerwacjaId ) {
        return new ResponseEntity<>(biletService.addBiletWithRezerwacjaAndMiejsce(bilet, miejsceId, rezerwacjaId), HttpStatus.CREATED);
    }




    @PutMapping("/{id}")
    public ResponseEntity<Bilet> updateBilet(@PathVariable Integer id, @RequestBody Bilet bilet) {
        Optional<Bilet> currentBilet = biletService.getBiletById(id);
        if (currentBilet.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bilet.setId(id);
        return new ResponseEntity<>(biletService.updateBilet(bilet), HttpStatus.OK);
    }

    @PutMapping("/typ/{id}")
    public ResponseEntity<Bilet> setBiletType(@PathVariable Integer id, @RequestParam("typ") String typ) {
        Optional<Bilet> currentBilet = biletService.getBiletById(id);
        if (currentBilet.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(typ.equals("ulgowy")){
            currentBilet.get().setCenabiletu(8.99);
        } else if (typ.equals("grupowy")){
            currentBilet.get().setCenabiletu(6.99);
        } else if(typ.equals("normalny")){
            currentBilet.get().setCenabiletu(11.99);
        }
        currentBilet.get().setTypbiletunazwatypubiletu(Typbiletu.valueOf(typ));

        return new ResponseEntity<>(biletService.updateBilet(currentBilet.get()), HttpStatus.OK);
    }

    @PutMapping("/miejsce/{id}")
    public ResponseEntity<Bilet> setBiletMiejsceType(@PathVariable Integer id, @RequestParam("typ") String typ) {
        Optional<Bilet> currentBilet = biletService.getBiletById(id);
        if (currentBilet.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(typ.equals("VIP") && currentBilet.get().getTypmiejsca().equals(Typmiejsca.standard)){
            currentBilet.get().setCenabiletu(currentBilet.get().getCenabiletu() * 1.5);
        } else if (typ.equals("standard") && currentBilet.get().getTypmiejsca().equals(Typmiejsca.VIP)){
            currentBilet.get().setCenabiletu(currentBilet.get().getCenabiletu() / 1.5);
        }
        currentBilet.get().setTypmiejsca(Typmiejsca.valueOf(typ));

        return new ResponseEntity<>(biletService.updateBilet(currentBilet.get()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBiletById(@PathVariable Integer id) {
        if (biletService.getBiletById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        biletService.deleteBiletById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
