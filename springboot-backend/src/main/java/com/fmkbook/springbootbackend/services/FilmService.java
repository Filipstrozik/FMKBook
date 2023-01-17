package com.fmkbook.springbootbackend.services;

import com.fmkbook.springbootbackend.exception.UserNotFoundException;
import com.fmkbook.springbootbackend.models.Film;
import com.fmkbook.springbootbackend.models.Film;
import com.fmkbook.springbootbackend.models.Uzytkownik;
import com.fmkbook.springbootbackend.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FilmService {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Film addFilm(Film film) {
        return this.filmRepository.save(film);
    }

    public List<Film> findAllFilms() {
        return this.filmRepository.findAll();
    }

//TODO Think about it later.
//    public Film updateFilm(Integer idUser, String idFilmu) {
//        Optional<Film> Film = this.filmRepository.findFilmById(idFilmu);
//        Optional<Uzytkownik> uzytkownik = uzytkownikRepository.findUzytkownikById(idUser);
//        if (Film.isPresent() && uzytkownik.isPresent() && Film.get().getUzytkownikiduzytkownika() == null) {
//            Film.get().setUzytkownikiduzytkownika(uzytkownik.get());
//            FilmRepository.save(Film.get());
//            return Film.get();
//        }
//        return null;
//    }

    public Film findFilmById(Integer id) {
        return this.filmRepository.findFilmById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteFilm(Integer id) {
        this.filmRepository.deleteFilmById(id);
    }


}
