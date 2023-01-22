package com.fmkbook.springbootbackend.repositories;

import com.fmkbook.springbootbackend.models.Film;
import com.fmkbook.springbootbackend.models.Seans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeansRepository extends JpaRepository<Seans, Integer> {
    List<Seans> findAllByFilmidfilmu(Film film);
}
