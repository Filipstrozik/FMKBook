package com.fmkbook.springbootbackend.services;

import com.fmkbook.springbootbackend.exception.UserNotFoundException;
import com.fmkbook.springbootbackend.models.Abonament;
import com.fmkbook.springbootbackend.models.Film;
import com.fmkbook.springbootbackend.models.Kino;
import com.fmkbook.springbootbackend.models.Seans;
import com.fmkbook.springbootbackend.repositories.FilmRepository;
import com.fmkbook.springbootbackend.repositories.KinoRepository;
import com.fmkbook.springbootbackend.repositories.SeansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SeansService {
    private final SeansRepository seansRepository;
    private  final FilmRepository filmRepository;
    private final KinoRepository kinoRepository;

    @Autowired
    public SeansService(SeansRepository seansRepository, FilmRepository filmRepository, KinoRepository kinoRepository) {
        this.seansRepository = seansRepository;
        this.filmRepository = filmRepository;
        this.kinoRepository = kinoRepository;
    }



    public Seans addSeans(Seans seans){
        return this.seansRepository.save(seans);
    }
    public Seans addSeansWithFilm(Integer filmId, Seans seans){
        Optional<Film> foundFilm = this.filmRepository.findFilmById(filmId);
        if(foundFilm.isEmpty()){
            return null;
        }
        seans.setFilmidfilmu(foundFilm.get());
        return this.seansRepository.save(seans);
    }

    public List<Seans> findAllSeans() {
        return this.seansRepository.findAll();
    }

    public List<Seans> findAllSeansOfFilm(Integer filmId) {
        Optional<Film> foundFilm = this.filmRepository.findFilmById(filmId);
        if(foundFilm.isEmpty()){
            return null;
        }
        return this.seansRepository.findAllByFilmidfilmu(foundFilm.get());
    }

    public Optional<Seans> findSeansById(Integer id) {
        return seansRepository.findById(id);
    }

    public void deleteSeans(Integer id){
        this.seansRepository.deleteById(id);
    }

    public Seans updateSeans(Seans seans) {
        return this.seansRepository.save(seans);
    }



    public Seans updateSeansWithKino(Seans seans, Integer kinoId) {
        Optional<Kino> foundKino = this.kinoRepository.findKinoById(kinoId);
        if(foundKino.isEmpty()){
            return null;
        }
        seans.setKinoidkina(foundKino.get());
        return this.seansRepository.save(seans);
    }
}
