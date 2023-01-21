package com.fmkbook.springbootbackend.controllers;

import com.fmkbook.springbootbackend.models.Miejsce;
import com.fmkbook.springbootbackend.services.MiejsceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/miejsce")
public class MiejsceApi {
    private final MiejsceService miejsceService;

    public MiejsceApi(MiejsceService miejsceService) {
        this.miejsceService = miejsceService;
    }

    @GetMapping
    public ResponseEntity<List<Miejsce>> getAllMiejsces() {
        return new ResponseEntity<>(miejsceService.getAllMiejsces(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Miejsce> getMiejsceById(@PathVariable Integer id) {
        Optional<Miejsce> miejsce = miejsceService.getMiejsceById(id);
        return miejsce.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Miejsce> addMiejsce(@RequestBody Miejsce miejsce) {
        return new ResponseEntity<>(miejsceService.addMiejsce(miejsce), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Miejsce> updateMiejsce(@PathVariable Integer id, @RequestBody Miejsce miejsce) {
        Optional<Miejsce> currentMiejsce = miejsceService.getMiejsceById(id);
        if (currentMiejsce.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        miejsce.setId(id);
        return new ResponseEntity<>(miejsceService.updateMiejsce(miejsce), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMiejsce(@PathVariable Integer id) {
        if (miejsceService.getMiejsceById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        miejsceService.deleteMiejsceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
