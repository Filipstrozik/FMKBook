package com.fmkbook.springbootbackend.controllers;

import com.fmkbook.springbootbackend.models.Sala;
import com.fmkbook.springbootbackend.models.Seans;
import com.fmkbook.springbootbackend.services.SeansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seans")
public class SeansApi {
    private final SeansService seansService;

    @Autowired

    public SeansApi(SeansService seansService) {
        this.seansService = seansService;
    }

    @GetMapping
    public ResponseEntity<List<Seans>> getAllSeans () {
        List<Seans> seansList = seansService.findAllSeans();
        return new ResponseEntity<>(seansList, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Seans> getSeans(@PathVariable("id") Integer id) {
        Optional<Seans> currentSeans = seansService.findSeansById(id);
        if (currentSeans.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(currentSeans.get(), HttpStatus.OK);
    }

    @GetMapping("/film/{id}")
    public ResponseEntity<List<Seans>> getAllSeans (@PathVariable("id") Integer idFilm) {
        List<Seans> seansList = seansService.findAllSeansOfFilm(idFilm);
        return new ResponseEntity<>(seansList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Seans> addSeans(@RequestBody Seans seans) {
        Seans newSeans = seansService.addSeans(seans);
        return new ResponseEntity<>(newSeans, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Seans> addSeans(@PathVariable("id") Integer idFilm, @RequestBody Seans seans) {
        Seans newSeans = seansService.addSeansWithFilm(idFilm, seans);
        return new ResponseEntity<>(newSeans, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seans> updateSala(@PathVariable Integer id, @RequestBody Seans seans) {
        Optional<Seans> currentSeans = seansService.findSeansById(id);
        if (currentSeans.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(seansService.updateSeans(seans), HttpStatus.OK);
    }

    @PutMapping("/{id}/kino/{idKino}")
    public ResponseEntity<Seans> updateSala(@PathVariable Integer id, @RequestBody Seans seans, @PathVariable Integer idKino) {
        Optional<Seans> currentSeans = seansService.findSeansById(id);
        if (currentSeans.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(seansService.updateSeansWithKino(seans, idKino), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeans (@PathVariable("id") Integer id) {
        seansService.deleteSeans(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
