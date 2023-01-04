package com.fmkbook.springbootbackend.controllers;


import com.fmkbook.springbootbackend.models.Abonament;
import com.fmkbook.springbootbackend.services.AbonamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abonament")
public class AbonamentApi {
    private final AbonamentService abonamentService;

    @Autowired
    public AbonamentApi(AbonamentService abonamentService) {
        this.abonamentService = abonamentService;
    }

    @GetMapping
    public ResponseEntity<List<Abonament>> getAllAbonaments () {
        List<Abonament> abonamentList = abonamentService.findAllAbonaments();
        return new ResponseEntity<>(abonamentList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abonament> getAbonament(@PathVariable("id") Integer id) {
        Abonament abonament = abonamentService.findAbonamentById(id);
        return new ResponseEntity<>(abonament, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Abonament> addAbonament(@RequestBody Abonament abonament) {
        Abonament newAbonament = abonamentService.addAbonament(abonament);
        return new ResponseEntity<>(newAbonament, HttpStatus.CREATED);
    }

    //TODO this does not work
    @PutMapping
    public ResponseEntity<Abonament> updateAbonament(@RequestBody Abonament abonament) {
        Abonament updatedAbonament = abonamentService.updateAbonament(abonament);
        return new ResponseEntity<>(updatedAbonament, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAbonament (@PathVariable("id") Integer id) {
        abonamentService.deleteAbonament(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
