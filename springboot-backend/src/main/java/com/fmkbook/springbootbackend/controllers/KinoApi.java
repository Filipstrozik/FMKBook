package com.fmkbook.springbootbackend.controllers;

import com.fmkbook.springbootbackend.models.Kino;
import com.fmkbook.springbootbackend.services.KinoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kino")
public class KinoApi {

    private final KinoService kinoService;

    public KinoApi(KinoService kinoService) {
        this.kinoService = kinoService;
    }

    @GetMapping
    public ResponseEntity<List<Kino>> getAllKinos() {
        return new ResponseEntity<>(kinoService.getAllKino(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kino> getKinoById(@PathVariable Integer id) {
        Kino kino = kinoService.getKinoById(id);
        if (kino == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(kino, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Kino> addKino(@RequestBody Kino kino) {
        return new ResponseEntity<>(kinoService.addKino(kino), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kino> updateKino(@PathVariable Integer id, @RequestBody Kino kino) {
        Kino currentKino = kinoService.getKinoById(id);
        if (currentKino == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        kino.setId(id);
        return new ResponseEntity<>(kinoService.updateKino(kino), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKinoById(@PathVariable Integer id) {
        if (kinoService.getKinoById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        kinoService.deleteKinoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
