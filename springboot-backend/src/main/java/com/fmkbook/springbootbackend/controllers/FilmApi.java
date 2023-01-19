package com.fmkbook.springbootbackend.controllers;


import com.fmkbook.springbootbackend.models.Film;
import com.fmkbook.springbootbackend.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmApi {
    private final FilmService filmService;

    @Autowired
    public FilmApi(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms () {
        List<Film> filmList = filmService.findAllFilms();
        return new ResponseEntity<>(filmList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilm(@PathVariable("id") Integer id) {
        Film film = filmService.findFilmById(id);
        return new ResponseEntity<>(film, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Film> addFilm(@RequestBody Film film) {
        Film newFilm = filmService.addFilm(film);
        return new ResponseEntity<>(newFilm, HttpStatus.CREATED);
    }

    //TODO this does not work
//    @CrossOrigin
//    @PutMapping()
//    public ResponseEntity<Film> updateFilm(@RequestParam("idUser") Integer idUser, @RequestParam("idRabatu") Integer idTypFilmu) {
//        Film film = this.filmService.updateFilm(idUser, idTypFilmu);
//        if(film != null){
//            return new ResponseEntity<>(film, HttpStatus.OK);
//        }
//        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFilm (@PathVariable("id") Integer id) {
        filmService.deleteFilm(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
