package com.fmkbook.springbootbackend.repositories;

import com.fmkbook.springbootbackend.models.Bilet;
import com.fmkbook.springbootbackend.models.Rezerwacja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BiletRepository extends JpaRepository<Bilet, Integer> {
    List<Bilet> findAllByRezerwacjaidrezerwacjiId(Integer id);
}
