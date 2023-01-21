package com.fmkbook.springbootbackend.repositories;

import com.fmkbook.springbootbackend.models.Film;
import com.fmkbook.springbootbackend.models.Kino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KinoRepository extends JpaRepository<Kino, Integer> {

    Optional<Kino> findKinoById(Integer id);
}
