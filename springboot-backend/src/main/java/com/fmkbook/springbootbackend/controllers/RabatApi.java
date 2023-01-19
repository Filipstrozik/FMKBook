package com.fmkbook.springbootbackend.controllers;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fmkbook.springbootbackend.models.Rabat;
import com.fmkbook.springbootbackend.services.RabatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rabat")
public class RabatApi {
    private final RabatService rabatService;

    @Autowired
    public RabatApi(RabatService rabatService) {
        this.rabatService = rabatService;
    }


    @GetMapping
    public ResponseEntity<List<Rabat>> getAllRabats () {
        List<Rabat> rabatList = this.rabatService.findAllRabats();
        return new ResponseEntity<>(rabatList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rabat> getRabat(@PathVariable("id") String code) {
        Rabat rabat = this.rabatService.findRabatById(code);
        return new ResponseEntity<>(rabat, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rabat> addRabat(@RequestParam("idUser") Optional<Integer> idUser, @RequestParam("discount") Double discount) {
        Rabat newRabat = rabatService.addRabat(discount,idUser);
        return new ResponseEntity<>(newRabat, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping()
    public ResponseEntity<Rabat> updateRabat(@RequestParam("idUser") Integer idUser, @RequestParam("idRabatu") String idRabatu) {
        Rabat rabat = rabatService.updateRabat(idUser, idRabatu);
        if(rabat != null){
            return new ResponseEntity<>(rabat, HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAgent (@PathVariable("id") String id) {
        rabatService.deleteRabat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
