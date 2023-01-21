package com.fmkbook.springbootbackend.controllers;

import com.fmkbook.springbootbackend.models.Bilet;
import com.fmkbook.springbootbackend.models.Rezerwacja;
import com.fmkbook.springbootbackend.services.RezerwacjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rezerwacja")
public class RezerwacjaApi {

    private final RezerwacjaService rezerwacjaService;

    @Autowired
    public RezerwacjaApi(RezerwacjaService rezerwacjaService) {
        this.rezerwacjaService = rezerwacjaService;
    }

    @GetMapping
    public ResponseEntity<List<Rezerwacja>> findAll() {
        return new ResponseEntity<>(rezerwacjaService.getAllRezerwacjas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rezerwacja> findById(@PathVariable Integer id) {
        Optional<Rezerwacja> rezerwacja = rezerwacjaService.getRezerwacjaById(id);
        if (rezerwacja.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rezerwacja.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rezerwacja> create(@RequestBody Rezerwacja rezerwacja) {
        return ResponseEntity.ok(rezerwacjaService.createRezerwacja(rezerwacja));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rezerwacja> update(@PathVariable Integer id ,@RequestBody Rezerwacja rezerwacja) {
        Optional<Rezerwacja> currentRezerwacja = rezerwacjaService.getRezerwacjaById(id);
        if (currentRezerwacja.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rezerwacjaService.updateRezerwacja(id,rezerwacja), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        rezerwacjaService.deleteRezerwacja(id);
        return ResponseEntity.ok().build();
    }
}