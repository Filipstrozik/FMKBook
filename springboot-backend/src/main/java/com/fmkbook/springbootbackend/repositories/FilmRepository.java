package com.fmkbook.springbootbackend.repositories;

import com.fmkbook.springbootbackend.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    void deleteFilmById(Integer id);
    Optional<Film> findFilmById(Integer id);
}
