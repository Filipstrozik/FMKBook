package com.fmkbook.springbootbackend.controllers;

import com.fmkbook.springbootbackend.models.Seans;
import com.fmkbook.springbootbackend.services.SeansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        Seans seans = seansService.findSeansById(id);
        return new ResponseEntity<>(seans, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Seans> addSeans(@RequestBody Seans seans) {
        Seans newSeans = seansService.addSeans(seans);
        return new ResponseEntity<>(newSeans, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeans (@PathVariable("id") Integer id) {
        seansService.deleteSeans(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
