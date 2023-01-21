package com.fmkbook.springbootbackend.repositories;

import com.fmkbook.springbootbackend.models.Rezerwacja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RezerwacjaRepository extends JpaRepository<Rezerwacja, Integer> {

}
