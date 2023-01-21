package com.fmkbook.springbootbackend.controllers;

import com.fmkbook.springbootbackend.models.Sala;
import com.fmkbook.springbootbackend.services.SalaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sala")
public class SalaApi {

    private final SalaService salaService;

    public SalaApi(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public ResponseEntity<List<Sala>> getAllSalas() {
        return new ResponseEntity<>(salaService.getAllSalas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> getSalaById(@PathVariable Integer id) {
        Optional<Sala> sala = salaService.getSalaById(id);
        return sala.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Sala> addSala(@RequestBody Sala sala) {
        return new ResponseEntity<>(salaService.addSala(sala), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> updateSala(@PathVariable Integer id, @RequestBody Sala sala) {
        Optional<Sala> currentSala = salaService.getSalaById(id);
        if (currentSala.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        sala.setId(id);
        return new ResponseEntity<>(salaService.updateSala(sala), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalaById(@PathVariable Integer id) {
        if (salaService.getSalaById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        salaService.deleteSalaById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
