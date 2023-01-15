package com.fmkbook.springbootbackend.controllers;

import com.fmkbook.springbootbackend.models.Rabat;
import com.fmkbook.springbootbackend.models.Typabonamentu;
import com.fmkbook.springbootbackend.services.TypAbonamentuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typ-abonamentu")
public class TypAbonamenuApi {
    private final TypAbonamentuService typAbonamentuService;

    @Autowired
    public TypAbonamenuApi(TypAbonamentuService typAbonamentuService) {
        this.typAbonamentuService = typAbonamentuService;
    }

    @GetMapping
    public ResponseEntity<List<Typabonamentu>> getAllTypAbonamentu () {
        List<Typabonamentu> typyList = this.typAbonamentuService.findAllTypAbonamentu();
        return new ResponseEntity<>(typyList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Typabonamentu> getRabat(@PathVariable("id") Integer id) {
        Typabonamentu typ = this.typAbonamentuService.findAbonamentById(id);
        return new ResponseEntity<>(typ, HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Typabonamentu> updateTypAbonamentu(@PathVariable("id") Integer id, @RequestParam("cena") Double cena) {
        Typabonamentu typ = this.typAbonamentuService.updateTypAbonamentu(id, cena);
        if(typ != null){
            return new ResponseEntity<>(typ, HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Typabonamentu> addTypAbonamentu(@RequestBody Typabonamentu typ) {
        Typabonamentu newTyp = this.typAbonamentuService.addTypAbonamentu(typ);
        return new ResponseEntity<>(newTyp, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTypAbonamentu (@PathVariable("id") Integer id) {
        this.typAbonamentuService.deleteTypAbonamentu(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
