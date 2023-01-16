package com.fmkbook.springbootbackend.repositories;

import com.fmkbook.springbootbackend.models.Typabonamentu;
import com.fmkbook.springbootbackend.models.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypAbonamentuRepository extends JpaRepository<Typabonamentu, Integer> {
    Optional<Typabonamentu> findTypabonamentuById(Integer id);
}
